package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
