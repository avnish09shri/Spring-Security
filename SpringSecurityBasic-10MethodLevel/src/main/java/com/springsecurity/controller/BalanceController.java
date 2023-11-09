package com.springsecurity.controller;

import com.springsecurity.model.AccountTransactions;
import com.springsecurity.service.classes.AccountTransactionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    private final AccountTransactionServiceImpl balanceServiceImpl;

    public BalanceController(AccountTransactionServiceImpl balanceServiceImpl) {
        this.balanceServiceImpl = balanceServiceImpl;
    }

    @GetMapping("/myBalance")
    public ResponseEntity<List<AccountTransactions>> getBalanceDetails(@RequestParam int id) {
        return new ResponseEntity<>(balanceServiceImpl.findBalanceByCustomerId(id), HttpStatus.OK);
    }
}
