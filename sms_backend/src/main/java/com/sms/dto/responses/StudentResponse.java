package com.sms.dto.responses;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sms.entities.Attendance;
import com.sms.entities.ClassroomStudent;
import com.sms.entities.ExamResult;
import com.sms.entities.Parent;
import com.sms.entities.User;

public class StudentResponse implements Serializable{

	private static final long serialVersionUID = 9053495632076534023L;
	
	private Integer id;
	
	private String firstName;

	private String lastName;
	
	private Date dob;
	
	@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
	private String phone;
	
	private String mobile;
	
	
	private Date doj;
	
	private Boolean status;
	
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

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
