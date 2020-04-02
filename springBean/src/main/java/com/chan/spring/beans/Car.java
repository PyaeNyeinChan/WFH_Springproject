package com.chan.spring.beans;

public class Car {
	private String carName;
	
	Car(String carName) {
		super();
		this.carName = carName;
	}

	public void run() {
		System.out.printf("%s is running%n", carName);
	}
	
	public static Car getMark2() {
		return new Car("Mark2");
	}
}
