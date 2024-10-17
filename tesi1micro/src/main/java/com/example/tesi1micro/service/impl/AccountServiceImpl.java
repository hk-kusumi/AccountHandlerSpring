package com.example.tesi1micro.service.impl;

import com.example.tesi1micro.dto.AccountDto;
import com.example.tesi1micro.entity.Account;
import com.example.tesi1micro.mapper.AccountMapper;
import com.example.tesi1micro.repository.AccountRepository;
import com.example.tesi1micro.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public AccountDto withdrawById(Long id, double value) {
        Account account= accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found"));
        if(account.getBalance() < value +1000){
            throw new RuntimeException("Insufficient Balance");
        }
        double total =account.getBalance()-value;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto depositById(Long id, double value) {
        Account account= accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found"));
        double total =account.getBalance()+value;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public void deleteAcc(Long id) {
        Account account= accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found"));
        accountRepository.deleteById(id);
    }

    //----------------Important -------------
    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> allAccounts = accountRepository.findAll();
        return allAccounts.stream().map((account)->AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

}
