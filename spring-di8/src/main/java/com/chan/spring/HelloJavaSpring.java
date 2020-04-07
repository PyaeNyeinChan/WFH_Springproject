package com.chan.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class HelloJavaSpring {
	
	@Autowired
	private User user;
	
	public void sayHello() {
		System.out.println("Hello Java Configuration" + user.getName());
	}

}
