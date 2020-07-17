package com.chan.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootJpa1ApplicationTests {
	
	@Autowired
	private CustomerRepo repo;

	@Test
	void contextLoads() {
		Customer cust = new Customer();
		cust.setName("ChanChan");
		cust.setPhone("0997");
		cust.setEmail("chan@gmail.com");
		
		repo.save(cust);
		
		assertEquals(1, cust.getId());
	}

}
