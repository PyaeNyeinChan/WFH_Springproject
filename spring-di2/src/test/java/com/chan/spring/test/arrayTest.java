package com.chan.spring.test;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chan.spring.AbstractBeans;

public class arrayTest {
	private static ConfigurableApplicationContext CTX;
	
	@BeforeClass
	public static void setUpBeforeClass () throws Exception {
		CTX = new ClassPathXmlApplicationContext("spring-di2.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		CTX.close();
	}

	@Test
	public void test() {
		AbstractBeans bean = CTX.getBean("bean4",AbstractBeans.class);
		bean.showAll();
	}

}
