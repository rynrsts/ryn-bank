package com.rynbank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noticeId;

    private String noticeSummary;
    private String noticeDetails;
    private Date noticeStartDate;
    private Date noticeEndDate;
    private Date createDate;
    private Date updateDate;

}
