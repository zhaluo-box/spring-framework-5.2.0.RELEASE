package com.example.spring.learn.service;

import com.example.spring.learn.common.service.WelcomeService;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class DefaultWelcomeService implements WelcomeService {

	@Override
	public String sayHello(String name) {
		return "Hello," + name;
	}
}
