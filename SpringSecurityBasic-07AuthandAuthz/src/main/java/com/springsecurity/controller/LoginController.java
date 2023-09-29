package com.springsecurity.controller;


import com.springsecurity.model.Customer;
import com.springsecurity.model.response.CustomerResponse;
import com.springsecurity.service.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private CustomerServiceImpl customerService;

    public LoginController(CustomerServiceImpl customerService) {
        this.customerService=customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> newCustomer(@RequestBody Customer customer){
        CustomerResponse newCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);

    }

    @GetMapping("/user")
    public Customer getUserDetails(Authentication authentication){
        return customerService.findByEmail(authentication.getName());
    }

}
