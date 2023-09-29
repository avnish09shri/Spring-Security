package com.springsecurity.exception;

public class AccountsException extends RuntimeException {
    public AccountsException(int id) {
        super(String.format("Account Not Found for Customer id: 's' ", id));
    }
}
