package com.example.tesi1micro.mapper;

import com.example.tesi1micro.dto.AccountDto;
import com.example.tesi1micro.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account
                (accountDto.getId(), accountDto.getOwnerName(), accountDto.getBalance());
        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto =new AccountDto
                (account.getId(), account.getOwnerName(), account.getBalance());
        return accountDto;
    }
}
