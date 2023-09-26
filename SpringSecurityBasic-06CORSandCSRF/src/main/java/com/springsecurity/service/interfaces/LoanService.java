package com.springsecurity.service.interfaces;

import com.springsecurity.model.Loan;

import java.util.List;

public interface LoanService {

    List<Loan> findLoans(int id);
}
