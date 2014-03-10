package com.baseproject.service.user;

import com.baseproject.model.user.User;

public interface UserService {

	public static final String JNDI = "userService";
	
	User findUserByUsername(String username);
}
