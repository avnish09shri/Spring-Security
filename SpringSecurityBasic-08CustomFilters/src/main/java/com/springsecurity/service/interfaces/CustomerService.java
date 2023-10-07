package com.springsecurity.service.interfaces;

import com.springsecurity.model.Customer;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Customer findByEmail(String email);
}
