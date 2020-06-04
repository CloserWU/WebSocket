package com.example.demo;

import com.example.demo.util.SpringContextUtil;
import com.example.demo.util.TempleteTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
@SpringBootApplication(scanBasePackages = {"com.example.demo"})
public class WebSocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
    }


    /**
     * @Primary好像没有作用
     * @return
     */
    @Bean
    @Primary
    public String bean1() {
        return "val";
    }


    /**
     * 当bean有参数时，Spring会自动在全局ApplicationContext中找String类型的bean，并出入到val中，
     * 若spring容器中只有一个String 类型的bean，则不论参数取名为何都是按类型取bean String为参数，
     * 若有多个则参数取名必须为多个bean中的一个，否则报错。
     * Spring类型的bean当然不止一个，所以下面代码错误
     * @param val
     * @return
     */
    /*@Bean Error
    public String bean1(String val) {
        return "val";
    }
    */

    /**
     * 多个同名bean，后面的将会覆盖前面的
     * @param val
     * @return
     */
    @Bean
    @Primary
    public String bean1(TempleteTest<String> val) {
        val = new TempleteTest<>("templete的bean", "wushuai", 1);
        return val.getTemplete();
    }

    /**
     * 还是会注入上面的bean
     * 需要注意，要是SpringContextUtil已经有@Compinent注解，那么将重复注入，报错
     * @param val
     * @return
     */
    @Bean
    public String bean1(SpringContextUtil val) {
        return "springcontextutil的bean";
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
