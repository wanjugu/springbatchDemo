package com.securex.springsecurityDemo.controller;

import com.securex.springsecurityDemo.entities.Customer;
import com.securex.springsecurityDemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        ResponseEntity response = null;
        Customer savedCustomer = null;

        try {

            String hashedPassword = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(hashedPassword);

            savedCustomer = customerRepository.save(customer);
            if (savedCustomer.getId() > 0){
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body("User Registered Successfully.");
            }

        }catch (Exception ex){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured." + ex.getMessage());
        }

        return response;
    }

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication){
        List<Customer> customers = customerRepository.findByEmail(authentication.getName());
        if(customers.size() > 0 ){
            return customers.get(0);
        }
        return null;
    }

}
