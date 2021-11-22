package com.sms.dto.responses;

import java.io.Serializable;

public class UserResponse implements Serializable {
	
	private static final long serialVersionUID = -8698512212961052731L;

	private Long id;
	
	private String name;

	private String email;

	private String userType;
	
	private Object user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Object getUser() {
		return user;
	}

	public void setUser(Object user) {
		this.user = user;
	}
	
}
