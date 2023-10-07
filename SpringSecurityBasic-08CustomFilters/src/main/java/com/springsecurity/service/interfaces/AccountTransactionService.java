package com.springsecurity.service.interfaces;

import com.springsecurity.model.AccountTransactions;

import java.util.List;

public interface AccountTransactionService {

    List<AccountTransactions> findBalanceByCustomerId(int id);

}
