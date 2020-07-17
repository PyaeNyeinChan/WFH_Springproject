package com.chan.spring.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.chan.spring.model.FileStorageProp;

@Service
public class StorageService {

	private final Path fileStorageLocation;

	@Autowired
	public StorageService(FileStorageProp fileStorageProp) {
		this.fileStorageLocation = Paths.get(fileStorageProp.getUploadDir()).toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Path targetLocation = this.fileStorageLocation.resolve(fileName);
        try {
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
}
