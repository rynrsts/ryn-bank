package com.rynbank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class AccountTransaction {

    @Id
    private String transactionId;

    private long accountNumber;
    private int customerId;
    private Date transactionDate;
    private String transactionSummary;
    private String transactionType;
    private int transactionAmount;
    private int closingBalance;
    private String createDate;

}
