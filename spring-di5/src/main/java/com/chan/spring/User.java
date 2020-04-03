package com.chan.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	
	private Role role;
	
	@Autowired
	public void setRole(Role role) {
		this.role = role;
	}

	public void sayHello() {
		System.out.println("Hello Spring Annotation. I am " + role.getName());
	}
}
