package com.chan.spring;

import java.util.Scanner;

public class ScannerFactory {
	
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
}
