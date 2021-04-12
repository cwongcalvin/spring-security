package com.cwongcalvin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home", "/h2-console/**").permitAll() // (3)
				.anyRequest().authenticated() // (4)
				.and()
			.formLogin() // (5)
			//	.loginPage("/login")  
				.permitAll()
				.and()
			.logout() // (6)
				.permitAll()
				.and()
			.httpBasic()
		    	.and()
		    .csrf().ignoringAntMatchers("/h2-console/**")
	        	.and()
	        .headers().frameOptions().sameOrigin();	

	}

}
