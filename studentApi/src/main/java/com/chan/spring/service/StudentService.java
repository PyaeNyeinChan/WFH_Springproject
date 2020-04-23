package com.chan.spring.service;

import org.springframework.data.repository.CrudRepository;

import com.chan.spring.model.Student;

public interface StudentService extends CrudRepository<Student, Integer> {

}
