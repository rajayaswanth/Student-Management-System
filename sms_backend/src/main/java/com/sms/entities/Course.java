package com.sms.entities;

import java.io.Serializable;
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
public class Course implements Serializable {

	private static final long serialVersionUID = 6575863835964112556L;

	@Id
	@Column(name = "course_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	
	private String name;
	
	private String description;
	
	@JsonBackReference(value = "course_grade")
	@ManyToOne
	@JoinColumn(name = "grade_id")
	private Grade grade;
	
	@JsonManagedReference(value = "course_examresult")
	@OneToMany(mappedBy = "course", orphanRemoval = true)
	private List<ExamResult> examResult;

	public List<ExamResult> getExamResult() {
		return examResult;
	}

	public void setExamResult(List<ExamResult> examResult) {
		this.examResult = examResult;
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

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}
