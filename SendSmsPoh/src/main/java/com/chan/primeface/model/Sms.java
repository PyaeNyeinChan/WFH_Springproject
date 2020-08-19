package com.chan.primeface.model;

public class Sms {
	private String to;
	private String message;
	private String sender;

	public Sms() {

	}

	public Sms(String to, String message, String sender) {
		super();
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
