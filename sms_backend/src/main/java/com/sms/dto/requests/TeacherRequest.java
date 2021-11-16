package com.sms.dto.requests;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TeacherRequest  implements Serializable {
	
	private static final long serialVersionUID = 5050422623378846585L;

		
	@NotNull(message= "Frist Name can't be null")
	@NotBlank(message = "Frist Name can't be blank")
	private String firstName;
	
	@NotNull(message = "Last Name can't be null")
	@NotBlank(message = "Last Name can't be blank")
	private String lastName;
	
	@NotNull(message = "dob can't be null")
	private Date dob;
	
	private String phone;
	
	@NotNull(message = "Mobile can't be null")
	@NotBlank(message = "Mobile can't be blank")
	private String mobile;
	
	private Boolean status;
	
	@NotNull(message = "Last Login Date can't be null")
	@NotBlank(message = "Last Login Date can't be blank")
	private Date lastLoginDate;
	
	@NotNull(message = "Last Login Ip can't be null")
	@NotBlank(message = "Last Login IP can't be blank")
	private String lastLoginIp;

	
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

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	
	
	
}
