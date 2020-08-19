package com.chan.primeface.view;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chan.primeface.model.Users;
import com.chan.primeface.repository.UsersRepository;
import com.chan.primeface.services.SendServices;

@Named
@ViewScoped
@ManagedBean(value = "customerViewService")
public class CustomerViewService implements Serializable {
	private static final long serialVersionUID = 1L;

	private RestTemplate restTemplate;
	final String token = "PZ7GVN96lRPtQQG4cnO8M3mPmg02K4Nqu7-rFHu4LuANKBiViCdT-K4tPRJz1jcK";
	private List<Users> customers;

	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	SendServices sendServices;

	@PostConstruct
	public void init() {
		customers = usersRepository.findAll();
	}

	public List<Users> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Users> customers) {
		this.customers = customers;
	}
	
	public void send(String phnum) {
		sendServices.sendSMS(phnum);
	}

}
