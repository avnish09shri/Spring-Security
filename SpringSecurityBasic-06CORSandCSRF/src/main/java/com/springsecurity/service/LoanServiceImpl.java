package com.springsecurity.service;

import com.springsecurity.model.Loan;
import com.springsecurity.repository.LoanRepository;
import com.springsecurity.service.interfaces.LoanService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<Loan> findLoans(int id) {
        List<Loan> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if(loans.size()>0 || loans!=null)
            return loans;
        else
            return new ArrayList<>();
    }
}
