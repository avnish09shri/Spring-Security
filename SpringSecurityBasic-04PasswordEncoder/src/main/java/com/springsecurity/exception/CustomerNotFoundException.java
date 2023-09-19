package com.springsecurity.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String email) {
        super(String.format("Customer Not found for '%s' : ", email));
    }
}
