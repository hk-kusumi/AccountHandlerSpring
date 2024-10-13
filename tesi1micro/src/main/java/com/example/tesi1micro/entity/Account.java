package com.example.tesi1micro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="account")
@Entity
@Getter
@Setter@AllArgsConstructor
@NoArgsConstructor


public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "account_owner_name")
    private  String ownerName;
    private double balance;
}
