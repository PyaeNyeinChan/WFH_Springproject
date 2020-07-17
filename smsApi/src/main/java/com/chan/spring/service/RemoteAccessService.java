package com.chan.spring.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.chan.spring.model.SMS;

@Service
public class RemoteAccessService {
	private RestTemplate restTemplate;
	private String baseURL;
	final String token = "PZ7GVN96lRPtQQG4cnO8M3mPmg02K4Nqu7-rFHu4LuANKBiViCdT-K4tPRJz1jcK";
	private SMS sms;

	public RemoteAccessService() {
	}

	@Autowired
	public RemoteAccessService(RestTemplate restTemplate, @Value("${service.url}") String baseURL) {
		this.restTemplate = restTemplate;
		this.baseURL = baseURL;
	}

	// Try to get Random Quote for restAPI in Application.properties
	public String getRandom() {
		return restTemplate.getForObject(baseURL + "/random", String.class);
	}

	public ResponseEntity<String> getBalance() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(baseURL + "/get-balance", HttpMethod.GET, entity,
				String.class);
		return responseEntity;
	}

	public ResponseEntity<String> sendSMS(SMS sms) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
//		Map<String, Object> map = new HashMap();
//		map.put("to", "09979007828");
//		map.put("message", "Hello World");
//		map.put("sender", "SMSPoh");
//		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
//		ResponseEntity<String> response = restTemplate.postForEntity(baseURL + "/send", entity, String.class);
		
		
//		HashMap<String, String> bodyParam = new HashMap<>();
//		bodyParam.put("to", sMS.getTo());
//		bodyParam.put("message", sMS.getMessage());
//		bodyParam.put("sender", sMS.getSender());
		
		MultiValueMap<String, String> postParams = new LinkedMultiValueMap<>();
		postParams.add("to", sms.getTo());
		postParams.add("message", sms.getMessage());
		postParams.add("sender", sms.getSender());
		
		HttpEntity<MultiValueMap<String, String>> requestEntity = 
				new HttpEntity<MultiValueMap<String,String>>(postParams,headers);
		
		return restTemplate.postForEntity(baseURL + "/send", requestEntity, String.class);
	}
}