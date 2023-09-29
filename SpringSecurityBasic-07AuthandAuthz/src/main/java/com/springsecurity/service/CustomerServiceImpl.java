package com.springsecurity.service;

import com.springsecurity.exception.CustomerNotFoundException;
import com.springsecurity.model.Customer;
import com.springsecurity.model.response.CustomerResponse;
import com.springsecurity.repository.CustomerRepository;
import com.springsecurity.service.interfaces.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CustomerResponse saveCustomer(Customer customer) {
        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        customer.setCreateDt(new Date(System.currentTimeMillis()));
        Customer newCustomer = customerRepository.save(customer);
        return mapToResponse(newCustomer);
    }

    private CustomerResponse mapToResponse(Customer customer) {
        CustomerResponse response=new CustomerResponse();
        BeanUtils.copyProperties(customer,response);
        return response;
    }

    public Customer findByEmail(String email){
        return customerRepository.findByEmail(email).orElseThrow(() -> new CustomerNotFoundException(email));
    }
}
