package com.baseproject.controller.spring;

import org.springframework.security.core.GrantedAuthority;

import com.baseproject.model.profile.Profile;

public class SpringProfile implements GrantedAuthority {
	
	private static final long serialVersionUID = -2860131210366928968L;
	
	private Profile profile;
	
	public SpringProfile(Profile profile) {
		this.profile = profile;
	}
	
	public Profile getProfile() {
		return profile;
	}

	@Override
	public String getAuthority() {
		return getProfile().getType().name();
	}
}
