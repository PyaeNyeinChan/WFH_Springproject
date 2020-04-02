package com.chan.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chan.spring.beans.HelloSpring;

class helloBeanTest {
	public static ConfigurableApplicationContext framework;
	private HelloSpring bean;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		framework = new ClassPathXmlApplicationContext("application.xml");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		framework.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		bean = framework.getBean("hello",HelloSpring.class);
	}

	@Test
	void test() {
		bean.sayHello();
	}

}
