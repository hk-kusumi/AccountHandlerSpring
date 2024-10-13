package com.example.tesi1micro.repository;

import com.example.tesi1micro.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
