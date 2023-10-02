package com.springsecurity.service.classes;

import com.springsecurity.model.Authority;
import com.springsecurity.model.Customer;
import com.springsecurity.repository.AuthorityRepository;
import com.springsecurity.repository.CustomerRepository;
import com.springsecurity.service.interfaces.CustomerService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    public CustomerServiceImpl(CustomerRepository customerRepository,  PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        customer.setCreateDt(String.valueOf(new Date(System.currentTimeMillis())));
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
