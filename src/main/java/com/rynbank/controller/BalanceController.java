package com.rynbank.controller;

import com.rynbank.model.AccountTransaction;
import com.rynbank.model.Customer;
import com.rynbank.repository.AccountTransactionRepository;
import com.rynbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/myBalance")
    public List<AccountTransaction> getBalanceDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);

        if (customers != null && !customers.isEmpty()) {
            return accountTransactionRepository.findByCustomerIdOrderByTransactionDateDesc(customers.get(0).getId());
        }

        return null;
    }

}
