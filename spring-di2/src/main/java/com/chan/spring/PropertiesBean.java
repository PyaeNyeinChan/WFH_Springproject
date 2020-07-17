package com.chan.spring;

import java.util.Properties;

public class PropertiesBean extends AbstractBeans{

	private Properties prop;
	
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	
	@Override
	public void showAll() {
		for (Object key : prop.keySet()) {
			System.out.printf("%s-1s : %s%n",key,prop.getProperty(key.toString()));
		}
	}

}
