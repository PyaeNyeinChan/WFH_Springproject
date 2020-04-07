package com.chan.spring;

import com.chan.spring.custom.GunRifel;

@GunRifel
public class Rifel implements Gun{

	@Override
	public void fire() {
		System.out.println("Bang!!!");
	}

}
