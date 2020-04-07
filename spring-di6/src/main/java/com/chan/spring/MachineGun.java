package com.chan.spring;

import org.springframework.beans.factory.annotation.Autowired;

import com.chan.spring.custom.GunMachine;

@GunMachine
public class MachineGun implements Gun {
	
	@Autowired
	private int bullet;

	@Override
	public void fire() {
		for (int i = 0; i < bullet; i++) {
			System.out.println("Bang!!!");
		}

	}

}
