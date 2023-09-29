package com.springsecurity.service;

import com.springsecurity.model.AccountTransactions;
import com.springsecurity.repository.AccountTransactionsRepository;
import com.springsecurity.service.interfaces.BalanceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final AccountTransactionsRepository accountTransactionsRepository;

    public BalanceServiceImpl(AccountTransactionsRepository accountTransactionsRepository) {
        this.accountTransactionsRepository = accountTransactionsRepository;
    }


    @Override
    public List<AccountTransactions> findBalanceByCustomerId(int id) {
        List<AccountTransactions> balance = accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
        if(balance.size()>0 || balance!=null)
            return balance;
        else
            return new ArrayList<>();
    }
}
