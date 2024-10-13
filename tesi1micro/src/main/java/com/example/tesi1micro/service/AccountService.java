package com.example.tesi1micro.service;

import com.example.tesi1micro.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount( AccountDto accountDto);
    AccountDto getAccountById( Long id);
}
