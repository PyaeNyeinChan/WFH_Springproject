package com.chan.spring.model;

import java.io.Serializable;

public class SMS implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String to;
	private String message;
	private String sender;

	public SMS() {
	}

	public SMS(String to, String message, String sender) {
		this.to = to;
		this.message = message;
		this.sender = sender;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

}
