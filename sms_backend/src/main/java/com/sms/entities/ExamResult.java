package com.sms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ExamResult implements Serializable {

	private static final long serialVersionUID = -482942589379555893L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	
	@JsonBackReference(value = "exam_examresult")
	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;
	
	@JsonBackReference(value = "student_examresult")
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@JsonBackReference(value = "course_examresult")
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	private String marks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

}
