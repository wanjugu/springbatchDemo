package com.securex.springsecurityDemo.controller;


import com.securex.springsecurityDemo.entities.Accounts;
import com.securex.springsecurityDemo.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class AccountController {
    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id) {
        Accounts accounts = accountsRepository.findByCustomerId(id);
        if (accounts != null) {
            return accounts;
        }

        return null;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> submitCSVReport(
            @RequestParam(value = "file", required = true) MultipartFile file
    ) throws Exception {

        String msg;

        if (!file.getName().isEmpty()) {
            // Process the file
            // For example, save it to the file system or database
            // You can access file properties using methods like file.getOriginalFilename(), file.getSize(), etc.
            msg =  "File uploaded successfully: " + file.getName();
        } else {
            msg =  "Failed to upload file. Please select a file.";
        }


        return ResponseEntity.ok(msg);

    }

}
