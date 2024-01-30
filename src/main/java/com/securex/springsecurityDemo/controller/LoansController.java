package com.securex.springsecurityDemo.controller;


import com.securex.springsecurityDemo.entities.Loans;
import com.securex.springsecurityDemo.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loans> getLoans(@RequestParam int id){
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if(loans != null){
            return loans;
        }

        return null;
    }
}
