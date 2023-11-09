package com.springsecurity.controller;

import com.springsecurity.model.Loans;
import com.springsecurity.service.classes.LoanServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    private final LoanServiceImpl loanServiceImpl;

    public LoansController(LoanServiceImpl loanServiceImpl) {
        this.loanServiceImpl = loanServiceImpl;
    }

    @GetMapping("/myLoans")
    public ResponseEntity<List<Loans>> getLoanDetails(@RequestParam int id) {
        return new ResponseEntity<>(loanServiceImpl.findLoans(id), HttpStatus.OK);
    }

}
