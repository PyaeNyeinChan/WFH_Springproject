package com.chan.springsecurity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.chan.springsecurity.model.User;
import com.chan.springsecurity.repository.UserRepository;

@SpringBootApplication
public class JwtAuth2Application {
	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(new User(101, "javatechie", "password", "javatechie@gmail.com"),
				new User(102, "user1", "pwd1", "user1@gmail.com"), new User(103, "user2", "pwd2", "user2@gmail.com"),
				new User(104, "user3", "pwd3", "user3@gmail.com")).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtAuth2Application.class, args);
	}

}
