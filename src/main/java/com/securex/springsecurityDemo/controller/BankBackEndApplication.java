package com.securex.springsecurityDemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankBackEndApplication {

    @GetMapping("/welcome")
    public String sayWelcome(){
        return "welcome to Spring Application with Basic Auth security";
    }



}
