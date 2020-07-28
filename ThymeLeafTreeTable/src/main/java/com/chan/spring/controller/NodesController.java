package com.chan.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chan.spring.model.Node;

@RestController
@RequestMapping("nodes")
public class NodesController {
	
	@GetMapping
	public List<Node> nodes(){
		return getSampleNodeList();
	}
	
	private List<Node> getSampleNodeList(){
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node("Root", "0", "Root", "http://chanchan.dev.com"));
		nodes.add(new Node("Child1", "Root", "Child1", "http://chanchan.dev.com/child1"));
		nodes.add(new Node("Child2", "Root", "Child2", "http://chanchan.dev.com/child2"));
		nodes.add(new Node("Child3", "Root", "Child3", "http://chanchan.dev.com/child3"));
		nodes.add(new Node("Child3.1", "Child3", "Child3.1", "http://chanchan.dev.com/child3/child1"));
		nodes.add(new Node("Child3.2", "Child3", "Child3.1", "http://chanchan.dev.com/childe3/child2"));
		nodes.add(new Node("Child4", "Root", "Child4", "http://chanchan.dev.com/child4"));
		nodes.add(new Node("Child4.1", "Childe4", "Childe4.1", "http://chanchan.dev.com/child4/child1"));
		return nodes;
	}
}