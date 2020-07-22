package com.chan.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
	
	@GetMapping("/customer")
	public String getAllCustomer(Model model) {
		return "customer.table.html";
	}

}
