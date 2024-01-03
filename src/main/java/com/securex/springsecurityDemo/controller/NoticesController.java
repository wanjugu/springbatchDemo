package com.securex.springsecurityDemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/notices")
    public String getLoans(){
        return "Showing Notices!!";
    }
}
