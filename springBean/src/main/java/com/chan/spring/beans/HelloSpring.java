package com.chan.spring.beans;

public class HelloSpring {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void sayHello() {
		System.out.println(name);
	}
}
