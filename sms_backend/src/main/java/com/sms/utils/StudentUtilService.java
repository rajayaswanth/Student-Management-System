package com.sms.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dto.requests.StudentRequest;
import com.sms.dto.requests.StudentUpdateRequest;
import com.sms.dto.responses.StudentResponse;
import com.sms.entities.Student;
import com.sms.repositories.StudentRepository;

@Service
public class StudentUtilService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student convertStudentReqToStudent(StudentRequest req) {
		Student student = new Student();
		student.setDob(req.getDob());
		student.setFirstName(req.getFirstName());
		student.setLastName(req.getLastName());
		student.setMobile(req.getMobile());
		student.setPhone(req.getPhone());
		student.setStatus(true);
		student.setDoj(req.getDoj());
		return student;
	}
	
	public StudentResponse convertStudentObjectToStudentRes(Student student) {
		StudentResponse response = new StudentResponse();
		response.setDob(student.getDob());
		response.setFirstName(student.getFirstName());
		response.setLastName(student.getLastName());
		response.setMobile(student.getMobile());
		response.setPhone(student.getPhone());
		response.setStatus(true);
		response.setDoj(student.getDoj());
		return response;
	}
	
	public Optional<Student> isStudentWithIdExists(Integer id){
		return studentRepository.findById(id);
	}
	
	public Map<Boolean, Student> canUpdate(StudentUpdateRequest req, Student student) {
		Map<Boolean, Student> response = new HashMap<>();
		if(req.getFirstName() != null && !req.getFirstName().isEmpty()) {
			if(!req.getFirstName().equals(student.getFirstName())) {
				student.setFirstName(req.getFirstName());
			}
		}
		if(req.getLastName() != null && !req.getLastName().isEmpty()) {
			if(!req.getLastName().equals(student.getLastName())) {
				student.setLastName(req.getLastName());
			}
		}
		if(req.getMobile() != null && !req.getMobile().isEmpty()) {
			if(!req.getMobile().equals(student.getMobile())) {
				student.setMobile(req.getMobile());
			}
		}
		if(req.getPhone() != null && !req.getPhone().isEmpty()) {
			if(!req.getPhone().equals(student.getPhone())) {
				student.setPhone(req.getPhone());
			}
		}
		if(req.getDob() != null) {
			if(!req.getDob().equals(student.getDob())) {
				student.setDob(req.getDob());
			}
		}
		if(req.getDoj() != null) {
			if(!req.getDoj().equals(student.getDoj())) {
				student.setDoj(req.getDoj());
			}
		}
		
		response.put(true, student);
		return response;
	}
	
}
