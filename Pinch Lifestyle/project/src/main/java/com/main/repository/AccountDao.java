package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Account;

public interface AccountDao extends JpaRepository<Account, Integer>{

}
