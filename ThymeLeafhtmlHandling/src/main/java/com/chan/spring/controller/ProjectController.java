package com.chan.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chan.spring.model.Project;

@Controller
public class ProjectController {
	
	@GetMapping("/create-project")
	public String createProjectForm(Model model) {
		model.addAttribute("project", new Project());
		return "create-project";
	}
	
	@PostMapping("/save-project")
	public String saveProjectSubmission(@ModelAttribute Project project) {
		return "result";
	}

}
