package com.chan.spring;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;
@Component
@Named("apartment")
public class House implements Residence {

	@Inject
	private String address;

	@Override
	public String getAddress() {
		return address;
	}

}
