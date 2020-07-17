package com.chan.spring;

public class Student {
	private String name;
	private int age;
	private Course course;

	public Student() {

	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String greet() {
		return String.format("Hello My name is %s and I am %d years old.", name, age);
	}
}
