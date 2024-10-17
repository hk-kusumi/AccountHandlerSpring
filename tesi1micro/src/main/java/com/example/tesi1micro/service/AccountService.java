package com.example.tesi1micro.service;

import com.example.tesi1micro.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount( AccountDto accountDto);

    AccountDto getAccountById( Long id);

    List<AccountDto> getAllAccounts ();

    AccountDto withdrawById(Long id, double value);

    AccountDto depositById(Long id, double value);

    void deleteAcc(Long id);
}
