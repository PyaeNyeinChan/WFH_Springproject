package com.chan.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car {

	private String name;

	public Car(String name) {
		super();
		this.name = name;
	}

	public void drive() {
		System.out.printf("%s is driving!%n", name);
	}
	
	@PostConstruct
	public void init() throws Exception{
		System.out.printf("%s is initialize%n", name);
	}
	
	@PreDestroy
	public void destory() throws Exception{
		System.out.printf("Destory");
	}
}
