package com.sms.dto.requests;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.sms.entities.Attendance;
import com.sms.entities.ClassroomStudent;
import com.sms.entities.ExamResult;
import com.sms.entities.Parent;
import com.sms.entities.User;

public class StudentRequest implements Serializable {

	
	private static final long serialVersionUID = -833925090986331073L;

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
	
	@NotNull(message = "Parent can't be null")
	@NotBlank(message = "Parent can't be blank")
	private Parent parent;
	
	@NotNull(message = "Attendance can't be null")
	@NotBlank(message = "Attendance can't be blank")
	private List<Attendance> attendance;
	
	@NotNull(message = "ExamResult can't be null")
	@NotBlank(message = "ExamResult can't be blank")
	private List<ExamResult> examResult;
	
	@NotNull(message = "ClassRoomOfStudent can't be null")
	@NotBlank(message = "ClassRoomOfStudent can't be blank")
	private List<ClassroomStudent> classRoomStudent;
	
	@NotNull(message = "DateOfJoin can't be null")
	private Date doj;
	
	private Boolean status;
	
	@NotNull(message = "LastLoginDate can't be null")
	private Date lastLoginDate;
	
	@NotNull(message = "LastLoginTp can't be null")
	@NotBlank(message = "LastLoginTp can't be blank")
	private String lastLoginIp;
	
	@NotNull(message = "User can't be null")
	@NotBlank(message = "User can't be blank")
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
