package com.springsecurity.controller;

import com.springsecurity.model.Loan;
import com.springsecurity.service.LoanServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    private final LoanServiceImpl loanServiceImpl;

    public LoanController(LoanServiceImpl loanServiceImpl) {
        this.loanServiceImpl = loanServiceImpl;
    }

    @GetMapping("/myLoans")
    public ResponseEntity<List<Loan>> getLoansDetails(@RequestParam int id){

        return new ResponseEntity<>(loanServiceImpl.findLoans(id), HttpStatus.OK);
    }
}
