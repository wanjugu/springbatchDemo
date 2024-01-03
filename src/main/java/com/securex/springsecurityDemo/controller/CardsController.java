package com.securex.springsecurityDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardsController {
    @GetMapping("/myCards")
    public String getCardsDetails(){
        return "Showing the Cards Details from the DB!!";
    }
}
