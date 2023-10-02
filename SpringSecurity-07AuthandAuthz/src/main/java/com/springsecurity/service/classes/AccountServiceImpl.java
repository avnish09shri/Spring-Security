package com.springsecurity.service.classes;

import com.springsecurity.model.Accounts;
import com.springsecurity.repository.AccountsRepository;
import com.springsecurity.service.interfaces.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountsRepository accountsRepository;

    public AccountServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }


    @Override
    public Accounts findAccountByCustomerId(int id) {
        return accountsRepository.findByCustomerId(id);
    }
}
