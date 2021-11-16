package com.sms.entities;

import java.io.Serializable;
import java.time.Year;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ClassRoom implements Serializable {

	private static final long serialVersionUID = -9071048284540837602L;

	@Id
	@Column(name = "classroom_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	
	private Year year;
	
	@JsonBackReference(value = "classroom_grade")
	@ManyToOne
	@JoinColumn(name = "grade_id")
	private Grade grade;
	
	@JsonManagedReference(value = "classroom_classroomstudent")
	@OneToMany(mappedBy = "classroom", orphanRemoval = true)
	private List<ClassroomStudent> classRoomStudent;
	
	private String section;
	
	private Boolean status;
	
	private String remarks;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

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

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
