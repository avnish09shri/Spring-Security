package com.springsecurity.model.response;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Date;

@Data
public class ContactResponse {

    @Column(name = "contact_id")
    private String contactId;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_email")
    private String contactEmail;

    private String subject;

    private String message;

    @Column(name = "create_dt")
    private Date createDt;
}
