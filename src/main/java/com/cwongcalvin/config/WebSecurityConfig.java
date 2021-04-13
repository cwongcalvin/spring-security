package com.cwongcalvin.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/h2-console/**").permitAll() // (3)
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

	@Resource
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}

	/*
	public DaoAuthenticationProvider authProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailsService);
	    authProvider.setPasswordEncoder(encoder());
	    return authProvider;
	}
	*/

}
