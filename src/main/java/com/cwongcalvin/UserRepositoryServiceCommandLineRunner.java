package com.cwongcalvin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.cwongcalvin.entity.User;
import com.cwongcalvin.service.UserRepository;

@Service
public class UserRepositoryServiceCommandLineRunner implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(UserRepositoryServiceCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("cwong", "password", "USER");
		userRepository.save(user);
		
		user = new User("awong", "password", "ADMIN");
		userRepository.save(user);
		
		List<User> users = userRepository.findAll();
		log.info("All Users: " + users);

	}

}
