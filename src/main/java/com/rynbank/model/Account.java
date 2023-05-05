package com.rynbank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {

    private int customerId;

    @Id
    private long accountNumber;

    private String accountType;
    private String branchAddress;
    private String createDate;

}
