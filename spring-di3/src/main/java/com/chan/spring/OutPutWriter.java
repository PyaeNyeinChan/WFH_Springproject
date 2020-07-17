package com.chan.spring;

public class OutPutWriter {
	private InputReader reader;

	public OutPutWriter(InputReader reader) {
		super();
		this.reader = reader;
	}
	
	public void echo(String message) {
		String result = reader.read(message);
		System.out.println(result);
	}
}
