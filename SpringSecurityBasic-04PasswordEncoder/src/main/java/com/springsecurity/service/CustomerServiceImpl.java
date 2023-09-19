package com.springsecurity.service;

import com.springsecurity.model.Customer;
import com.springsecurity.model.response.CustomerResponse;
import com.springsecurity.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{


    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CustomerResponse saveCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer newCustomer = customerRepository.save(customer);
        return mapToResponse(newCustomer);
    }

    private CustomerResponse mapToResponse(Customer customer) {
        CustomerResponse response=new CustomerResponse();
        BeanUtils.copyProperties(customer,response);
        return response;
    }
}
