package com.springsecurity.model.response;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Date;

@Data
public class CustomerResponse {

    @Column(name = "customer_id")
    private int id;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    private String pwd;

    private String role;

    @Column(name = "create_dt")
    private Date createDt;

}
