package com.chan.primeface.services;

import java.util.Collections;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.chan.primeface.model.Sms;
import com.chan.primeface.model.Users;

@Service
public class SendServices {
	private RestTemplate restTemplate;
	private String baseURL;
	final String token = "PZ7GVN96lRPtQQG4cnO8M3mPmg02K4Nqu7-rFHu4LuANKBiViCdT-K4tPRJz1jcK";
	private Sms sms;
	private Users users;

	public SendServices(RestTemplate restTemplate, @Value("${service.url}") String baseURL) {
		this.restTemplate = restTemplate;
		this.baseURL = baseURL;
	}

	public ResponseEntity<String> sendSMS(String phnum) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		Map<String, Object> map = new HashMap();
		map.put("to", phnum);
		map.put("message", "Hello World");
		map.put("sender", "SMSPoh");
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(baseURL + "/send", entity, String.class);
		return response;
	}
}
