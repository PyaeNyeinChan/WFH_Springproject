package com.chan.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.chan.spring")
public class MyApplication {
	
	@Bean
	public String name() {
		return " Chan";
	}

}
