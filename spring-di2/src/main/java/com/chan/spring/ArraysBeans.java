package com.chan.spring;

public class ArraysBeans extends AbstractBeans {

	private String[] arrays;

	public String[] getArrays() {
		return arrays;
	}

	public void setArrays(String[] arrays) {
		this.arrays = arrays;
	}

	@Override
	public void showAll() {
		for (String string : arrays) {
			System.out.println(string);
		}

	}

}
