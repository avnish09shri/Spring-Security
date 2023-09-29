package com.springsecurity.service.interfaces;

import com.springsecurity.model.response.AccountResponse;

public interface AccountService {

    AccountResponse getAccountDetails(int id);
}
