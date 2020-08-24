package com.spring.boot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ServiceConfiguration {

	@Autowired private Environment env;
	
	
	
}
