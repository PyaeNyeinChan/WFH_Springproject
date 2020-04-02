package com.chan.spring.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chan.spring.Student;

public class SpringTest {
	private static ConfigurableApplicationContext CTX;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		CTX = new ClassPathXmlApplicationContext("application.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		CTX.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		Student s1 = CTX.getBean("Chan",Student.class);
		assertEquals("Chan Chan", s1.getName());
		assertEquals(23, s1.getAge());
		assertEquals("Hello My name is Chan Chan and I am 23 years old.", s1.greet());
		assertEquals("Java EE", s1.getCourse().getName());
		assertEquals(300000, s1.getCourse().getFees());
	}
	@Test
	public void test2() {
		Student s1 = CTX.getBean("Myat",Student.class);
		assertEquals("Toon Myat Thmwe", s1.getName());
		assertEquals(20, s1.getAge());
		assertEquals("Hello My name is Toon Myat Thmwe and I am 20 years old.", s1.greet());
		assertEquals("Java SE", s1.getCourse().getName());
		assertEquals(150000, s1.getCourse().getFees());
	}
	@Test
	public void test3() {
		Student s1 = CTX.getBean("ngwe",Student.class);
		assertEquals("SuNgweAung", s1.getName());
		assertEquals(20, s1.getAge());
		assertEquals("Hello My name is SuNgweAung and I am 20 years old.", s1.greet());
		assertEquals("Spring Framework", s1.getCourse().getName());
		assertEquals(300000, s1.getCourse().getFees());
	}

}
