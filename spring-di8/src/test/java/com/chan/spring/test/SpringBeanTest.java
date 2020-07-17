package com.chan.spring.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chan.spring.HelloJavaSpring;
import com.chan.spring.config.MyApplication;

public class SpringBeanTest {
	private static ConfigurableApplicationContext CTX;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		CTX = new AnnotationConfigApplicationContext(MyApplication.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		CTX.close();
	}
	@Test
	public void test() {
		HelloJavaSpring Hello = CTX.getBean(HelloJavaSpring.class);
		Hello.sayHello();
	}

}
