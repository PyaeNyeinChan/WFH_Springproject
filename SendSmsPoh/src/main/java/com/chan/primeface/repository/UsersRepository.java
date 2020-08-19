package com.chan.primeface.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chan.primeface.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
