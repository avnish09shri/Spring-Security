package com.springsecurity.controller;

import com.springsecurity.model.response.AccountResponse;
import com.springsecurity.service.AccountServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountServiceImpl accountServiceImpl;

    public AccountController(AccountServiceImpl accountServiceImpl) {
        this.accountServiceImpl = accountServiceImpl;
    }


    @GetMapping("/myAccount")
    public ResponseEntity<AccountResponse> getAccountDetails(@RequestParam int id){
        accountServiceImpl.getAccountDetails(id);
        return new ResponseEntity<>(accountServiceImpl.getAccountDetails(id), HttpStatus.OK);
    }
}
