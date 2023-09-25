package com.springsecurity.service;

import com.springsecurity.exception.AccountsException;
import com.springsecurity.model.Account;
import com.springsecurity.model.response.AccountResponse;
import com.springsecurity.repository.AccountRepository;
import com.springsecurity.service.interfaces.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public AccountResponse getAccountDetails(int id) {
        Account account = accountRepository.findByCustomerId(id).orElseThrow(() -> new AccountsException(id));
        return mapToResponse(account);
    }

    private AccountResponse mapToResponse(Account account) {
        AccountResponse accountResponse=new AccountResponse();
        BeanUtils.copyProperties(account, accountResponse);
        return accountResponse;
    }
}
