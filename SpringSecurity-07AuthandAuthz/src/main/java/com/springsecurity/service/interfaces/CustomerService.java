package com.springsecurity.service.interfaces;

import com.springsecurity.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Customer findByEmail(String email);
}
