package com.cwongcalvin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cwongcalvin.entity.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findById(username);
		return toUserDetails(user.get());
	}

	private UserDetails toUserDetails(User userObject) {
		return org.springframework.security.core.userdetails.User.withUsername(userObject.getLogin())
				.password(userObject.getPassword()).roles(userObject.getRole()).build();
	}

}
