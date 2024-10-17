package com.example.tesi1micro.controlller;

import com.example.tesi1micro.dto.AccountDto;
import com.example.tesi1micro.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountByID(@PathVariable Long id){
        AccountDto accountDto= accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //GetAll
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts= accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }


    //withdraw
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdrawMoney(@PathVariable Long id, @RequestBody double value){
        AccountDto accountDto= accountService.withdrawById(id, value);
        return ResponseEntity.ok(accountDto);
    }

    //deposit
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositMoney(@PathVariable Long id, @RequestBody double value){
        AccountDto accountDto= accountService.depositById(id, value);
        return ResponseEntity.ok(accountDto);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deLeteAccoutPermenent(@PathVariable Long id){
        accountService.deleteAcc(id);
        return ResponseEntity.ok("Delete Account Successfully");
    }

}
