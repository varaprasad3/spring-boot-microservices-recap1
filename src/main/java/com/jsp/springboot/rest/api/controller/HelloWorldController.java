package com.jsp.springboot.rest.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // HTTP GET REQUEST
    // Get call http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String sayHello() {
        return "Hello World";
    }
}
