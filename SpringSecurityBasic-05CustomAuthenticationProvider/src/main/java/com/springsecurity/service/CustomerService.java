package com.springsecurity.service;

import com.springsecurity.model.Customer;
import com.springsecurity.model.response.CustomerResponse;

public interface CustomerService {

    CustomerResponse saveCustomer(Customer customer);

}
