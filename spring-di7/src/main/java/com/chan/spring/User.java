package com.chan.spring;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;
@Component
public class User {
	
	@Inject
	@Named("house")
	private Residence residence;
	
	public void showAddress() {
		System.out.println(residence.getAddress());
	}

}
