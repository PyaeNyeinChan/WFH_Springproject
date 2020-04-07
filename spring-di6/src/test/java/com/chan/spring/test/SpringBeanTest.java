package com.chan.spring.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chan.spring.Actor;

public class SpringBeanTest {
	private static ConfigurableApplicationContext CTX;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		CTX = new ClassPathXmlApplicationContext("application.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		CTX.close();
	}

	@Test
	public void test() {
		CTX.getBean(Actor.class).fight();
	}

}
