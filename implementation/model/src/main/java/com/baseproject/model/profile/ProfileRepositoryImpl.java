package com.baseproject.model.profile;

import com.baseproject.model.common.BaseRepositoryImpl;

public class ProfileRepositoryImpl extends BaseRepositoryImpl<Profile> implements ProfileRepository {

	protected ProfileRepositoryImpl() {
		super(Profile.class);
	}
}
