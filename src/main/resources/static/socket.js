let socket = null
function newSocket() {
    // 方式一
    // socket = new WebSocket('ws://localhost:8080/socket/1')
    // 方式二
    socket = new WebSocket('ws://localhost:8080/socketv2/1')
    socket.onopen = (event) => {
        console.log("socket open")
    }
    socket.onmessage = (event) => {
        const res = JSON.parse(event.data)
        console.log( "Received Message: " );
        console.log(res)
    }
    socket.onclose = (event) => {
        console.log("Connection closed.");
    };
    socket.onerror = (event) => {
        socket.close();
        console.log("Connection error.");
    }
}
function sendMessage(params) {
    const param = {
        id: 1,
        name: "wushuai"
    }
    socket.send(JSON.stringify(param))
}

