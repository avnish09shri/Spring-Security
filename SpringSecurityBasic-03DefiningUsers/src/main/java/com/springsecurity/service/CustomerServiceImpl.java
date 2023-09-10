package com.springsecurity.service;

import com.springsecurity.model.Customer;
import com.springsecurity.model.response.CustomerResponse;
import com.springsecurity.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponse saveCustomer(Customer customer) {

        return mapToResponse(customerRepository.save(customer));
    }

    private CustomerResponse mapToResponse(Customer customer) {
        CustomerResponse response=new CustomerResponse();
        BeanUtils.copyProperties(customer,response);
        return response;
    }
}
