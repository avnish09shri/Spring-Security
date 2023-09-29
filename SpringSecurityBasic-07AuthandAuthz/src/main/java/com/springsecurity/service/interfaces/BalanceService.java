package com.springsecurity.service.interfaces;

import com.springsecurity.model.AccountTransactions;

import java.util.List;

public interface BalanceService {

    List<AccountTransactions> findBalanceByCustomerId(int id);
}
