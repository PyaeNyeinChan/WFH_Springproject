package com.chan.spring;

public class MachineGun implements Gun {
	private int bullet;
	
	public void setBullet(int b) {
		bullet = b;
	}

	@Override
	public void fire() {
		for(int i = 0; i < bullet; i++) {
			System.out.println("Bang!!!");
		}
	}
}
