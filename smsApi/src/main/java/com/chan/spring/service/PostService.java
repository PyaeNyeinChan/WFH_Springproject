package com.chan.spring.service;

import org.springframework.context.annotation.ComponentScan;

import com.chan.spring.model.SMS;

@ComponentScan
public interface PostService {
	public SMS sendSMS(SMS sms);
}
