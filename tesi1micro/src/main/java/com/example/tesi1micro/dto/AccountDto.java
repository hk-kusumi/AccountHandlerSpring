package com.example.tesi1micro.dto;

import lombok.*;


@Data
public class AccountDto {
    private long id;
    private  String ownerName;
    private double balance;

    public AccountDto(long id, String ownerName, double balance) {
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
    }
}
