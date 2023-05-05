package com.rynbank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Contact {

    @Id
    private String contactId;

    private String contactName;
    private String contactEmail;
    private String subject;
    private String message;
    private Date createDate;

}
