package com.example.demo.controller;


import com.example.demo.util.Dog;
import com.example.demo.util.TempleteTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>SocketHandler</p>
 * <p>description</p>
 *
 * @author wushuai
 * @version 1.0.0
 * @date 2020-06-04 13:27
 */
public class SocketHandler extends TextWebSocketHandler {

    private Logger logger = LoggerFactory.getLogger(SocketHandler.class);

    /**
     * 相当于Controller
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(session.getAttributes());
        Map<String, Object> value = objectMapper.readValue(message.getPayload(), HashMap.class);
        System.out.println(value);


        TempleteTest<Dog> t = new TempleteTest<>(new Dog("dog"), "wushuai", 1);
        TextMessage msg = new TextMessage(objectMapper.writeValueAsString(t));
        session.sendMessage(msg);
    }


}
