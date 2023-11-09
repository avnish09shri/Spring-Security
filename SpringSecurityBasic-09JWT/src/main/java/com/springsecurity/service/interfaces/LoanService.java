package com.springsecurity.service.interfaces;

import com.springsecurity.model.Loans;

import java.util.List;

public interface LoanService {

    List<Loans> findLoans(int id);
}
