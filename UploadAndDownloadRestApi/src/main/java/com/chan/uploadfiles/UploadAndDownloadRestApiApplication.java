package com.chan.uploadfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.chan.uploadfiles.storage.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadAndDownloadRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadAndDownloadRestApiApplication.class, args);
	}

}
