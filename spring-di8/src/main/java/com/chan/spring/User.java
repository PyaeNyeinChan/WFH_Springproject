package com.chan.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
	@Autowired
	private String name;

	public String getName() {
		return name;
	}

}
