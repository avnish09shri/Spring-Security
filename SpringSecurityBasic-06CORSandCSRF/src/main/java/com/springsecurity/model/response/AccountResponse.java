package com.springsecurity.model.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AccountResponse {

    @Column(name = "customer_id")
    private int customerId;

    @Column(name="account_number")
    private long accountNumber;

    @Column(name="account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "create_dt")
    private String createDt;
}
