package com.employeecrud.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class DefaultController {

    @RequestMapping("/")
    public String home(){
        return "hello-world-from-default-controller";
    }
}
