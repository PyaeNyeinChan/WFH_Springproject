package com.chan.primeface.model;

import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ManagedBean(value = "Car")
public class Cars {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String brand;
	private int year;
	private String color;

	public Cars() {

	}

	public Cars(long id, String brand, int year, String color) {
		this.id = id;
		this.brand = brand;
		this.year = year;
		this.color = color;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
