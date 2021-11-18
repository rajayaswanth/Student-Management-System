package com.sms.dto.responses;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

public class TeacherResponse implements Serializable {

	
	private static final long serialVersionUID = -7578914091526264175L;

	private Integer id;
	
	private String firstName;

	private String lastName;
	
	private Date dob;
	
	@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
	private String phone;
	
	private String mobile;
	
	private Boolean status;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
