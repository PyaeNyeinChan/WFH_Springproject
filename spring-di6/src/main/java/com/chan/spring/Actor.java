package com.chan.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.chan.spring.custom.MachineBullet;

@Component
public class Actor {
	
	@MachineBullet
	private Gun gun;
	
	public void fight() {
		gun.fire();
	}
}
