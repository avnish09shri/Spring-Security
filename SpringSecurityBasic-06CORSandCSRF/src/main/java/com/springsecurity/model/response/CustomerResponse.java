package com.springsecurity.model.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerResponse {

    @Column(name = "customer_id")
    private int id;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "pwd")
    private String password;

    private String role;

    @Column(name = "create_dt")
    private String createDt;

}
