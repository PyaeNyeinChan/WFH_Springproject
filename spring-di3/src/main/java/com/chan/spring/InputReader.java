package com.chan.spring;

import java.util.Scanner;

public class InputReader {
	private Scanner scanner;
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	public String read(String question) {
		System.out.print(question + " > ");
		return scanner.nextLine();
	}
}
