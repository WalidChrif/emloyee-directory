package com.employeecrud.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth2")
public class GoogleController {

    @RequestMapping
    public String login(Authentication authentication){
        System.out.println("Principal : " + authentication.getPrincipal());
        System.out.println("Details : " + authentication.getDetails());
        System.out.println("Credentials : " + authentication.getCredentials());
        System.out.println("Authorities : " + authentication.getAuthorities());
        return "Hello-World";
    }
}
