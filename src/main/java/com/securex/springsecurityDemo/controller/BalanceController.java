package com.securex.springsecurityDemo.controller;

import com.securex.springsecurityDemo.entities.AccountTransactions;
import com.securex.springsecurityDemo.repository.AccountsTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BalanceController {
    @Autowired
    AccountsTransactionsRepository accountsTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalance(@RequestParam int id){
        List<AccountTransactions> accountTransactions = accountsTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
        if(accountTransactions != null){
            return  accountTransactions;
        }

        return null;
    }
}
