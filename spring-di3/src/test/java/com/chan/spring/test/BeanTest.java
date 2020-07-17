package com.chan.spring.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chan.spring.OutPutWriter;

public class BeanTest {
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
		OutPutWriter bean = CTX.getBean(OutPutWriter.class);
		bean.echo("Show Message");
	}
}
