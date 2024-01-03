package com.securex.springsecurityDemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("/contact")
    public String contactInquiryDetails(){
        return "Showing Contacts Details!!";
    }
}
