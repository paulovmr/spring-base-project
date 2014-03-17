package com.baseproject.controller.spring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.baseproject.model.profile.Profile;
import com.baseproject.model.user.User;

public class SpringUser implements UserDetails {
	
	private static final long serialVersionUID = -6367849647170764656L;
	
	private User user;
	
	private List<SpringProfile> springProfiles;
	
	public SpringUser(User user) {
		this.user = user;
		
		this.springProfiles = new ArrayList<SpringProfile>();
		for (Profile profile : user.getProfiles()) {
			this.springProfiles.add(new SpringProfile(profile));
		}
	}

	public User getUser() {
		return user;
	}
	
	public List<SpringProfile> getSpringProfiles() {
		return springProfiles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getSpringProfiles();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isActive();
	}
}
