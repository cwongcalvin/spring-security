package com.cwongcalvin;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwongcalvin.entity.User;
import com.cwongcalvin.service.UserRepository;

@RestController
public class LoginController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public List<User> login() {
		List<User> users = userRepository.findAll();
		return users;
	}

}
