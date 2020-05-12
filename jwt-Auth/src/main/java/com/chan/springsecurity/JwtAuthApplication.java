package com.chan.springsecurity;

import java.util.ArrayList;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;

import com.chan.springsecurity.model.Role;
import com.chan.springsecurity.model.User;
import com.chan.springsecurity.service.UserService;

@SpringBootApplication
public class JwtAuthApplication {
	
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	private void run(String... params) throws Exception {
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setEmail("chan@gmail.com");
		admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));
		
		userService.signup(admin);
		
		User client = new User();
		client.setUsername("client");
		client.setPassword("client");
		client.setEmail("client@gmail.com");
		client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));
		
		userService.signup(client);
	}
}
