package com.sms.dto.requests;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.sms.entities.Attendance;
import com.sms.entities.ClassroomStudent;
import com.sms.entities.ExamResult;
import com.sms.entities.Parent;
import com.sms.entities.User;

public class StudentUpdateRequest implements Serializable{
	
	
	private static final long serialVersionUID = 3337880934364582027L;

	private String firstName;

	private String lastName;
	
	private Date dob;
	
	private String phone;
	
	private String mobile;
	
	private Parent parent;
	
	private List<Attendance> attendance;
	
	private List<ExamResult> examResult;
	
	private List<ClassroomStudent> classRoomStudent;
	
	private Date doj;
	
	private Boolean status;
	
	private Date lastLoginDate;
	
	private String lastLoginIp;
	
	private User user;

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

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

	public List<ExamResult> getExamResult() {
		return examResult;
	}

	public void setExamResult(List<ExamResult> examResult) {
		this.examResult = examResult;
	}

	public List<ClassroomStudent> getClassRoomStudent() {
		return classRoomStudent;
	}

	public void setClassRoomStudent(List<ClassroomStudent> classRoomStudent) {
		this.classRoomStudent = classRoomStudent;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
