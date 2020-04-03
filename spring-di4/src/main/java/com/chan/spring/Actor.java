package com.chan.spring;

public class Actor {

	private Gun gun;
	
	public void setGun(Gun gun) {
		this.gun = gun;
	}
	
	public void fight() {
		gun.fire();
	}
}
