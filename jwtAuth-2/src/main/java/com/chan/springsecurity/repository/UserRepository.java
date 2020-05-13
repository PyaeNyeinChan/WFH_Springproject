package com.chan.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chan.springsecurity.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
