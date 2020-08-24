package com.spring.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "oauth/authorize")
		.permitAll()
		.antMatchers("api/students")
		.hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.permitAll()
		.and()
		.logout()
		.permitAll();
		
		http.csrf().disable();
	}
	
	public void configure(AuthenticationManagerBuilder authenticationManager) throws Exception {
		authenticationManager.inMemoryAuthentication()
		.withUser("client")
		.password(passwordEncoder.encode("secret"))
		.authorities("ROLE_ADMIN");
	}
}
