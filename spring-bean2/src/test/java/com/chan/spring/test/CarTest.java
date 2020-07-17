package com.chan.spring.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chan.spring.beans.Car;

public class CarTest {
	private static ConfigurableApplicationContext CTX;
	private Car car;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		CTX = new ClassPathXmlApplicationContext("app.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		CTX.close();
	}

	@Before
	public void setUp() throws Exception {
		car = CTX.getBean(Car.class);
	}

	@Test
	public void test() {
		car.drive();
	}

}
