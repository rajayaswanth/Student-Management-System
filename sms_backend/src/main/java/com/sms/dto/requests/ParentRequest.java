package com.sms.dto.requests;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ParentRequest implements Serializable {
	
	private static final long serialVersionUID = 7548522628066138310L;

	@NotNull(message = "Email can't be null")
	@NotBlank(message = "Email can't be blank")
	@Email
	private String email;

	@NotNull(message = "Password can't be null")
	@NotBlank(message = "Password can't be blank")
	private String password;

	@NotNull(message = "FirstName can't be null")
	@NotBlank(message = "FirstName can't be blank")
	private String firstName;

	@NotNull(message = "LastName can't be null")
	@NotBlank(message = "LastName can't be blank")
	private String lastName;

	@NotNull(message = "dob can't be null")
	private Date dob;
	
	private String phone;

	@NotNull(message = "Mobile can't be null")
	@NotBlank(message = "Mobile can't be blank")
	private String mobile;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
