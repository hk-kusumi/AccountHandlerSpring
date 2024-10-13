package com.example.tesi1micro.service.impl;

import com.example.tesi1micro.dto.AccountDto;
import com.example.tesi1micro.entity.Account;
import com.example.tesi1micro.mapper.AccountMapper;
import com.example.tesi1micro.repository.AccountRepository;
import com.example.tesi1micro.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount( AccountDto accountDto){
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account= accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found"));
        return AccountMapper.mapToAccountDto(account);
    }

}
