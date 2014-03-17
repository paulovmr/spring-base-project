package com.baseproject.model.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.baseproject.model.common.BaseEntity;
import com.baseproject.model.profile.Profile;
import com.baseproject.util.validation.NotEmpty;

@Entity
@Table(name = "UserTable")
public class User extends BaseEntity {

	private static final long serialVersionUID = 64264926208955788L;

	@NotEmpty
	@Column(nullable = false)
	private String username;

	@NotEmpty
	@Column(nullable = false)
	private String password;

	@NotEmpty
	@ManyToMany
	private List<Profile> profiles;
	
	@Column(nullable = false)
	private boolean active = true;
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public List<Profile> getProfiles() {
		return profiles;
	}
	
	public boolean isActive() {
		return active;
	}
}
