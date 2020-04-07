package com.chan.spring.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chan.spring.config.ApplicationConfig;
import com.chan.spring.domain.Customer;
import com.chan.spring.repo.CustomerRepo;

public class CustomerTest {
	private static ConfigurableApplicationContext CTX;
	private CustomerRepo repo;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		CTX = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		CTX.close();
	}

	@Before
	public void setUp() throws Exception {
		repo = CTX.getBean(CustomerRepo.class);
	}

	@Test
	public void test1() {
		Customer c = new Customer();
		c.setName("Chan Chan");
		c.setEmail("chan@batman.com");
		c.setPhone("911");
		
		repo.create(c);
		
		assertEquals(1, c.getId());
	}
	
	@Test
	public void test2() {
		List<Customer> list = repo.findAll();
		assertEquals(1, list.size());
	}

	@Test
	public void test3() {
		Customer c = repo.find(1);
		assertEquals("Chan Chan", c.getName());
		assertEquals("chan@batman.com", c.getEmail());
		assertEquals("911", c.getPhone());
	}
	
	@Test
	public void test4() {
		List<Customer> list = repo.findByName("Chan Chan");	
		assertEquals(1, list.size());
		
		Customer c = repo.find(1);
		c.setName("Won Won");
		repo.update(c);
		
		list = repo.findByName("Chan Chan");
		assertEquals(0, list.size());
	}
	
	@Test
	public void test5() {
		repo.delete(1);
		Customer c = repo.find(1);
		assertNull(c);
	}

}