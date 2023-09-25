package com.springsecurity.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;

    @Column(name = "pwd")
    private String password;
    private String role;
}
