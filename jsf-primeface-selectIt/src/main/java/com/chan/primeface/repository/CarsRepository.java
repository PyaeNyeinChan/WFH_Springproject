package com.chan.primeface.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chan.primeface.model.Cars;

public interface CarsRepository extends JpaRepository<Cars, Long> {

}
