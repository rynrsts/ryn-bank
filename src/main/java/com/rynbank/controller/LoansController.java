package com.rynbank.controller;

import com.rynbank.model.Customer;
import com.rynbank.model.Loan;
import com.rynbank.repository.CustomerRepository;
import com.rynbank.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/myLoans")
    public List<Loan> getLoanDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);

        if (customers != null && !customers.isEmpty()) {
            return loanRepository.findByCustomerIdOrderByStartDateDesc(customers.get(0).getId());
        }

        return null;
    }

}
