package com.springsecurity.model.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CustomerResponse {
    private int id;
    private String email;

    @Column(name = "pwd")
    private String password;
    private String role;

}
