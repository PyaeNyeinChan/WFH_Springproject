package com.chan.springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.chan.springboot.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
