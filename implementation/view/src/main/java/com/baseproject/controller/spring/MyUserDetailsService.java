package com.baseproject.controller.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.baseproject.model.user.User;
import com.baseproject.model.user.UserRepository;

public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.findUserByUsernameWithProfiles(username);
		
		SpringUser springUser;
		
		if (user != null) {
			springUser = new SpringUser(user);
		} else {
			springUser = null;
		}
		
		return springUser;
	}
}