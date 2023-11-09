package com.springsecurity.controller;

import com.springsecurity.model.Accounts;
import com.springsecurity.service.classes.AccountServiceImpl;
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
    public Accounts getAccountDetails(@RequestParam int id) {
        Accounts accounts = accountServiceImpl.findAccountByCustomerId(id);
        return accounts;
    }

}
