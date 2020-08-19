package com.chan.ctli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chan.ctli.model.iUser;

public interface iUserRepository extends JpaRepository<iUser, Integer> {

}
