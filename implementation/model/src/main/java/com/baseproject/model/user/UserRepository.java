package com.baseproject.model.user;

import com.baseproject.model.common.BaseRepository;

public interface UserRepository extends BaseRepository<User> {

	User findUserByUsername(String username);
}
