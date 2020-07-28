package com.chan.spring.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node {
	private String nodeId;
	private String pid;
	private String text;
	private String href;

	public Node(String nodeId, String pid, String text, String href) {
		this.nodeId = nodeId;
		this.pid = pid;
		this.text = text;
		this.href = href;
	}

}
