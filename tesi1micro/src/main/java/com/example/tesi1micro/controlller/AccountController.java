package com.example.tesi1micro.controlller;

import com.example.tesi1micro.dto.AccountDto;
import com.example.tesi1micro.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //post
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<> (accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get
    @GetMapping
    public ResponseEntity<AccountDto> getAccountByID(@PathVariable Long id){
        AccountDto accountDto= accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

}
