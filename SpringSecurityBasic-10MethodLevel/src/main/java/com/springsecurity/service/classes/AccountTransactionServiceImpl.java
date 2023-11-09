package com.springsecurity.service.classes;

import com.springsecurity.model.AccountTransactions;
import com.springsecurity.repository.AccountTransactionsRepository;
import com.springsecurity.service.interfaces.AccountTransactionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {

    private final AccountTransactionsRepository accountTransactionsRepository;

    public AccountTransactionServiceImpl(AccountTransactionsRepository accountTransactionsRepository) {
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
