package com.rynbank.controller;

import com.rynbank.model.Account;
import com.rynbank.model.Customer;
import com.rynbank.repository.AccountRepository;
import com.rynbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/myAccount")
    public Account getAccountDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);

        if (customers != null && !customers.isEmpty()) {
            return accountRepository.findByCustomerId(customers.get(0).getId());
        }

        return null;
    }

}
