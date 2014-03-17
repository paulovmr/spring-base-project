package com.baseproject.model.user;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.baseproject.model.common.BaseRepositoryImpl;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

	protected UserRepositoryImpl() {
		super(User.class);
	}

	@Override
	public User findUserByUsernameWithProfiles(String username) {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("username", username);
		
		Query query = createQuery("FROM User u LEFT JOIN FETCH u.profiles WHERE u.username = :username");
		setParameters(query, parameters);
		
		User user;
		try {
			user = (User) query.getSingleResult();
		} catch (NoResultException e) {
			user = null;
		}
		
		return user;
	}
}
