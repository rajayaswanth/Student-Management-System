package com.sms.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.sms.dto.requests.StudentRequest;
import com.sms.dto.requests.StudentUpdateRequest;
import com.sms.dto.responses.StudentResponse;
import com.sms.entities.Student;
import com.sms.repositories.StudentRepository;

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
		student.setAttendance(req.getAttendance());
		student.setClassRoomStudent(req.getClassRoomStudent());
		student.setDoj(req.getDoj());
		student.setExamResult(req.getExamResult());
		student.setParent(req.getParent());
		student.setUser(req.getUser());
		student.setLastLoginDate(req.getLastLoginDate());
		student.setLastLoginIp(req.getLastLoginIp());
		return student;
		 
	}
	
	public StudentResponse convertStudentObjectToStudentRes(Student student) {
		StudentResponse  response = new StudentResponse();
		response.setDob(response.getDob());
		response.setFirstName(response.getFirstName());
		response.setLastName(response.getLastName());
		response.setMobile(response.getMobile());
		response.setPhone(response.getPhone());
		response.setStatus(true);
		response.setAttendance(response.getAttendance());
		response.setClassRoomStudent(response.getClassRoomStudent());
		response.setDoj(response.getDoj());
		response.setExamResult(response.getExamResult());
		response.setParent(response.getParent());
		response.setUser(response.getUser());
		response.setLastLoginDate(response.getLastLoginDate());
		response.setLastLoginIp(response.getLastLoginIp());
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
		
		if(req.getAttendance() != null && !req.getAttendance().isEmpty()) {
			if(!req.getAttendance().equals(student.getAttendance())) {
				student.setAttendance(req.getAttendance());
			}
		}
		if(req.getClassRoomStudent() != null && req.getClassRoomStudent().isEmpty())
		{
			if(!req.getClassRoomStudent().equals(student.getClassRoomStudent())) {
				student.setClassRoomStudent(req.getClassRoomStudent());
			}
		}
		if(req.getExamResult() != null && req.getExamResult().isEmpty()) {
			if(!req.getExamResult().equals(student.getExamResult())) {
				student.setExamResult(req.getExamResult());
			}
		}
		if(req.getUser() != null) {
			if(!req.getUser().equals(student.getUser())) {
				student.setUser(req.getUser());
			}
		}
		if(req.getLastLoginDate() != null) {
			if(!req.getLastLoginDate().equals(student.getLastLoginDate())) {
				student.setLastLoginDate(req.getLastLoginDate());
			}
		}
		if(req.getLastLoginIp() != null && req.getLastLoginIp().isEmpty()) {
			if(!req.getLastLoginIp().equals(student.getLastLoginIp())) {
				student.setLastLoginIp(req.getLastLoginIp());
			}
		}
		response.put(true, student);
		return response;
	}
	
}
