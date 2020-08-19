package com.chan.primeface.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mvcController {

	@RequestMapping
	public String home() {
		return "/index.xhtml";
	}
}
