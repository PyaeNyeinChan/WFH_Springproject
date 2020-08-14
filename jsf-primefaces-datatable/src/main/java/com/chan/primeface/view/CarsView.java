package com.chan.primeface.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.chan.primeface.model.Car;
import com.chan.primeface.repository.CarRepository;

@Named
@ViewScoped
@ManagedBean(value = "carsView")
public class CarsView implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Car> cars;

	private Car selectedCar;

	@Autowired
	private CarRepository carRepository;

	@PostConstruct
	public void init() {
		cars = carRepository.findAll();
		// System.out.println("cars:" + cars);
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		this.selectedCar = selectedCar;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public void delete(Long id) {
		carRepository.deleteById(id);
	}
	
	public void selectID() {
		System.out.println(selectedCar.getId());
	}

}
