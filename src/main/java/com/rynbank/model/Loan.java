package com.rynbank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanNumber;

    private int customerId;
    private Date startDate;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
    private String createDate;

}
