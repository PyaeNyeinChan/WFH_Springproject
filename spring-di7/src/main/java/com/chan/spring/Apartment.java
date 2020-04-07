package com.chan.spring;

import javax.inject.Named;

import org.springframework.stereotype.Component;

@Component
@Named("apartment")
public class Apartment implements Residence {

	@Override
	public String getAddress() {
		return "Kalaw";
	}

}
