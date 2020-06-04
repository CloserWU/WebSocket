package com.example.demo;

import com.example.demo.util.Dog;
import com.example.demo.util.TempleteTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebSocketApplicationTests {

    private Logger logger = LoggerFactory.getLogger(WebSocketApplicationTests.class);

    @Autowired
    private String bean1;

    @Test
    void contextLoads() {
    }

    @Test
    void templeteTest() {
        logger.info(bean1);
        TempleteTest<String> test = new TempleteTest<>("1", "wushuai", 1);
        logger.info(test.toString());

        TempleteTest<Dog> test1 = new TempleteTest<>(new Dog("dog1"), "wushuai", 1);
        logger.info(test1.toString());
    }

}
