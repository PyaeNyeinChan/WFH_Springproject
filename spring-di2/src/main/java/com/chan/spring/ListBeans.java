package com.chan.spring;

import java.util.List;

public class ListBeans extends AbstractBeans {

	private List<String> list;

	public ListBeans(List<String> list) {
		super();
		this.list = list;
	}

	@Override
	public void showAll() {
		for (String string : list) {
			System.out.println(string);
		}

	}

}
