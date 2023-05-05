package com.rynbank.controller;

import com.rynbank.model.Card;
import com.rynbank.model.Customer;
import com.rynbank.repository.CardRepository;
import com.rynbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/myCards")
    public List<Card> getCardDetails(@RequestParam String email) {
        List<Customer> customers = customerRepository.findByEmail(email);

        if (customers != null && !customers.isEmpty()) {
            return cardRepository.findByCustomerId(customers.get(0).getId());
        }

        return null;
    }

}
