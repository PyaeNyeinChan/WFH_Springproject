package com.chan.primeface.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.chan.primeface.model.Car;
import com.chan.primeface.repository.CarRepository;

@Named
@ViewScoped
@ManagedBean(value = "carsView")
public class CarsView implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Car> cars;

	@Autowired
	private CarRepository carRepository;

	@PostConstruct
	public void init() {
		cars = carRepository.findAll();
		System.out.println("cars:" + cars);
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

}
