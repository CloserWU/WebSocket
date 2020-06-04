## demo中的学习点
1. @Bean的使用
2. SpringContextUtil工具类
3. 泛型的使用和泛型静态方法
4. WebSocket
5. ContextLoader时，若是加入了Mybatis包，在application.yml中，没有指明Spring.datasource注解，将会报错
6. Jackson的读写方法

### WebSocket
前端：
```js
socket= new WebSocket("ws://localhost:8080/socket")
socket.onopen = () => {}
socket.onmessage = () => {}
socket.onerror = () => {}
socket.onclose = () => {}
socket.send()
```
服务器端有两种方式可实现：
1. WebSocketHandler
    SocketHandler来继承TextWebSocketHandler
    SocketHandler就相当于socket的Controller
    
    在SocketHandler设置好后，就可以通过WebSocketConfig来注册
    WebSocketConfig基于WebSocketConfigurer来实现
    WebSocketHandlerRegistry类下的addHandler方法来进行注册
    需要注意的是，setAllowedOrigins进行跨域访问设置
    addInterceptors进行http请求设置
2. ServerEndpoint (推荐)
设置SocketController类，运用注解
```java
@OnClose
@OnOpen
@OnError
@OnMessage
```
调用`session.getBasicRemote().sendText(message);`发送
需要注意，要加入如下的Bean
```java
@Bean
public ServerEndpointExporter serverEndpointExporter() {
    return new ServerEndpointExporter();
}
```

WS连接过程中报错
- 200： 未设置http
- 404： url路径错误
- 403： 未设置跨域

##未解决
重名Bean的注入问题，@Primary和@Qualifer的区别