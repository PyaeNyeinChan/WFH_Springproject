package com.chan.spring.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Project implements Serializable {

	private Long id;
	private String title;
	private String type;
	private String color;
	private String description;
	private Integer days;
	private Double price;
	private Boolean featured;
	@DateTimeFormat
	private LocalDateTime launchDate;

	public Project() {
		super();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getFeatured() {
		return featured;
	}

	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}

	public LocalDateTime getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(LocalDateTime launchDate) {
		this.launchDate = launchDate;
	}

}
