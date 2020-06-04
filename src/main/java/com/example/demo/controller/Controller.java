package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Controller</p>
 * <p>description</p>
 *
 * @author wushuai
 * @version 1.0.0
 * @date 2020-06-04 15:12
 */
@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
   public String init() {
        return "index";
    }
}
