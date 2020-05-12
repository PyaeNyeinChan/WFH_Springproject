package com.chan.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chan.spring.model.SMS;
import com.chan.spring.service.RemoteAccessService;

@RestController
public class SmsController {

	@Autowired
	RemoteAccessService remoteAccess;

	@GetMapping("/randomQuote")
	public String getRandomQuote() {
		return remoteAccess.getRandom();
	}
	
	@GetMapping("/balance")
	public ResponseEntity<String> getAccBalance() {
		return remoteAccess.getBalance();
	}
	
	@PostMapping("/send")
	public ResponseEntity<String> sendSms(@RequestBody SMS sms){
		return remoteAccess.sendSMS(sms);
	}
	
//	@PostMapping("/v2/send")
//	public SMS createSMS(@RequestBody SMS sms) {
//		return postService.sendSMS(sms);
//	}
}
