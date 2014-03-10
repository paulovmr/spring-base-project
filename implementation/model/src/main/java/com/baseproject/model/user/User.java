package com.baseproject.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.baseproject.model.common.BaseEntity;

@Entity
@Table(name = "UserTable")
public class User extends BaseEntity {

	@Column
	private String username;
	
	public String getUsername() {
		return username;
	}
}
