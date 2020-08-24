package com.spring.boot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {

	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers()
		.antMatchers("api/")
		.and()
		.authorizeRequests()
		.anyRequest()
		.access("#oauth2.hasScope('read')");
	}
}
