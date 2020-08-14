package com.chan.primeface.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.chan.primeface.model.Cars;
import com.chan.primeface.repository.CarsRepository;

@Named
@ViewScoped
@ManagedBean(value = "carsViewService")
public class CarsViewService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private CarsRepository carsRepository;

	private List<Cars> cars;
	private Cars selectedCar;
	private List<Cars> selectedCars;

	@PostConstruct
	public void init() {
		cars = carsRepository.findAll();
	}

	public CarsRepository getCarsRepository() {
		return carsRepository;
	}

	public void setCarsRepository(CarsRepository carsRepository) {
		this.carsRepository = carsRepository;
	}

	public List<Cars> getCars() {
		return cars;
	}

	public void setCars(List<Cars> cars) {
		this.cars = cars;
	}

	public Cars getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Cars selectedCar) {
		this.selectedCar = selectedCar;
	}

	public List<Cars> getSelectedCars() {
		return selectedCars;
	}

	public void setSelectedCars(List<Cars> selectedCars) {
		this.selectedCars = selectedCars;
	}

	public void selectCarID() {
		System.out.println(selectedCar.getId());
	}

	public void mutiCarID() {
		for(Cars i : selectedCars) {
		System.out.println(i.getId());
		}
	}
}
