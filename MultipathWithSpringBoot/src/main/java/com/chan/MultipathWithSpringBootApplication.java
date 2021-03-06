package com.chan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.chan.springservices.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MultipathWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipathWithSpringBootApplication.class, args);
	}

}
