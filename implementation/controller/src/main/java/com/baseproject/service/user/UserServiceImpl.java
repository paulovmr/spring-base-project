package com.baseproject.service.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baseproject.model.user.User;
import com.baseproject.model.user.UserRepository;

@Transactional
@Service(UserService.JNDI)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
}
