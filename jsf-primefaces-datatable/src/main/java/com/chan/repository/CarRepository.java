package com.chan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chan.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
