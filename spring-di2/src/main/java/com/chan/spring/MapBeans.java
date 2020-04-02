package com.chan.spring;

import java.util.Map;

public class MapBeans extends AbstractBeans {
	private Map<String, String> map;
	
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	@Override
	public void showAll() {
		for (String key : map.keySet()) {
			System.out.printf("%14s: %s%n",key,map.get(key));
		}
		
	}

}
