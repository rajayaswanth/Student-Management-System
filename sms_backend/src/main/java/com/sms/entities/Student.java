package com.sms.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 6885588301344410482L;
	
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	
	@Column(name = "fname")
	private String firstName;

	@Column(name = "lname")
	private String lastName;
	
	private Date dob;
	
	private String phone;
	
	private String mobile;
	
	@JsonBackReference(value = "student_parent")
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Parent parent;
	
	@JsonManagedReference(value = "student_attendance")
	@OneToMany(mappedBy = "student", orphanRemoval = true)
	private List<Attendance> attendance;
	
	@JsonManagedReference(value = "student_examresult")
	@OneToMany(mappedBy = "student", orphanRemoval = true)
	private List<ExamResult> examResult;
	
	@JsonManagedReference(value = "student_classroom")
	@OneToMany(mappedBy = "student", orphanRemoval = true)
	private List<ClassroomStudent> classRoomStudent;
	
	@Column(name = "date_of_join")
	private Date doj;
	
	private Boolean status;
	
	@Column(name = "last_login_date")
	private Date lastLoginDate;
	
	@Column(name = "last_login_ip")
	private String lastLoginIp;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

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

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
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
