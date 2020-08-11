package com.chan.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.chan.model.FakeCar;
import com.chan.repository.CarServices;

public class FakeCarView {
	private List<FakeCar> cars;

	@Inject
	private CarServices service;

	@PostConstruct
	public void init() {
		cars = service.createCars(10);
	}

	public List<FakeCar> getCars() {
		return cars;
	}

	public void setService(CarServices service) {
		this.service = service;
	}
}
