package com.sms.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Grade implements Serializable {
	
	private static final long serialVersionUID = -9125054482798807249L;
	
	@Id
	@Column(name = "grade_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	
	private String name;
	
	private String description;
	
	@JsonManagedReference(value = "classroom_grade")
	@OneToMany(mappedBy = "grade", orphanRemoval = true)
	private List<ClassRoom> classroom;
	
	@JsonManagedReference(value = "course_grade")
	@OneToMany(mappedBy = "grade", orphanRemoval = true)
	private List<Course> course;

	public List<ClassRoom> getClassroom() {
		return classroom;
	}

	public void setClassroom(List<ClassRoom> classroom) {
		this.classroom = classroom;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
