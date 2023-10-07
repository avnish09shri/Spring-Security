package com.springsecurity.service.interfaces;

import com.springsecurity.model.Accounts;

public interface AccountService {

    Accounts findAccountByCustomerId(int id);
}
