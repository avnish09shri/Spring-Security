package com.springsecurity.service.classes;

import com.springsecurity.model.Loans;
import com.springsecurity.repository.LoanRepository;
import com.springsecurity.service.interfaces.LoanService;
import org.springframework.security.access.prepost.PreAuthorize;
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
    //@PreAuthorize("hasRole('USER')")
    public List<Loans> findLoans(int id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if(loans.size()>0 || loans!=null)
            return loans;
        else
            return new ArrayList<>();
    }
}
