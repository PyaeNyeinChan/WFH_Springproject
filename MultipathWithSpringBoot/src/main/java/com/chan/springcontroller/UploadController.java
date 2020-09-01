package com.chan.springcontroller;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.Resource;

import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {
	private final String UPLOAD_DIR = "C:/Chan/404Files/";
	
	@GetMapping("/")
	public String homepage() {
		return "index";
	}
	
	@PostMapping("/upload")
	public String uploadFile (@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
		if(file.isEmpty()) {
			attributes.addFlashAttribute("message","Please select a file to upload");
			return "redirect:/";
		}
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			Path path = Paths.get(UPLOAD_DIR + fileName);
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		attributes.addFlashAttribute("message","You successfully uploaded " + fileName + "!!!");
		return "redirect:/";
	}
	
//	@GetMapping("/download/{filename:.+}")
//	public ResponseEntity downloadFile(@PathVariable String filename){
//		Path path = Paths.get(UPLOAD_DIR + filename);
//		UrlResource resource = null;
//		try {
//			resource = new UrlResource(path.toUri());
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//		return ResponseEntity.ok()
//				.contentType(MediaType.parseMediaType(contentType))
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//				.body(resource);
//	}
	
	@ModelAttribute("abc")
	public String abc() {
		return "abcdefg";
	}
}
