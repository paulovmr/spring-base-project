package com.baseproject.model.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.baseproject.model.common.BaseEntity;
import com.baseproject.util.validation.NotNull;

@Entity
public class Profile extends BaseEntity {

	private static final long serialVersionUID = 7142612887584334218L;
	
	public static final String ADMIN = "admin";
	public static final String EMPLOYEE = "employee";
	public static final String USER = "user";
	
	@NotNull
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ProfileType type;
	
	public ProfileType getType() {
		return type;
	}
}
