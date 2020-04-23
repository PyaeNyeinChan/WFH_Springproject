package com.chan.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chan.spring.model.Student;
import com.chan.spring.service.StorageService;
import com.chan.spring.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	private StorageService storageService;
	
	@GetMapping("/student")
	Iterable<Student> getAllStd(){
		return studentService.findAll();
	}
	@GetMapping("/student/{id}")
	Optional<Student> findById(@PathVariable Integer id){
		return studentService.findById(id);
	}
	
	@PostMapping("/student")
	Student createStd(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	@DeleteMapping("/student/{id}")
	void deleteStd(@PathVariable Integer id) {
		studentService.deleteById(id);
	}
	
	@PutMapping("/student")
	Student updateStd(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	@PostMapping("/upload")
	void uploadPic(@RequestParam("file") MultipartFile file) {
		String fileName = storageService.storeFile(file);
	}
	
}
