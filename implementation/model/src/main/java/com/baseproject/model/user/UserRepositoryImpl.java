package com.baseproject.model.user;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.baseproject.model.common.BaseRepositoryImpl;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

	protected UserRepositoryImpl() {
		super(User.class);
	}

	@Override
	public User findUserByUsername(String username) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("username", username);
		
		Query query = createQuery("FROM User WHERE username = :username");
		setParameters(query, parameters);
		
		return (User) query.getSingleResult();
	}
}
