package com.sms.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dto.requests.TeacherRequest;
import com.sms.dto.requests.TeacherUpdateRequest;
import com.sms.dto.responses.TeacherResponse;
import com.sms.entities.Teacher;
import com.sms.repositories.TeacherRepository;

@Service
public class TeacherUtilService {

	@Autowired
	TeacherRepository teacherRepository;

	public Teacher convertTeacherReqToTeacher(TeacherRequest teacherRequest) {
		Teacher teacher = new Teacher();
		teacher.setDob(teacherRequest.getDob());
		teacher.setFirstName(teacherRequest.getFirstName());
		teacher.setLastName(teacherRequest.getLastName());
		teacher.setMobile(teacherRequest.getMobile());
		teacher.setPhone(teacherRequest.getPhone());
		teacher.setStatus(teacherRequest.getStatus());
		teacher.setLastLoginDate(teacherRequest.getLastLoginDate());
		teacher.setLastLoginIp(teacherRequest.getLastLoginIp());
		return teacher;
	}
	
	public TeacherResponse convertTeacherObjToTeacherRes(Teacher teacher) {
		TeacherResponse response = new TeacherResponse();
		response.setDob(teacher.getDob());
		response.setFirstName(teacher.getFirstName());
		response.setLastName(teacher.getLastName());
		response.setMobile(teacher.getMobile());
		response.setPhone(teacher.getPhone());
		response.setStatus(teacher.getStatus());
		response.setLastLoginDate(teacher.getLastLoginDate());
		response.setLastLoginIp(teacher.getLastLoginIp());
		return response;
	}
	
	public Optional<Teacher> isPresentWithExists(Integer id){
		return teacherRepository.findById(id);
	}
	
	public Map<Boolean, Teacher> canUpdate(TeacherUpdateRequest teacherUpdateRequest, Teacher teacher){
		Map<Boolean, Teacher> response = new HashMap<>();
		if(teacherUpdateRequest.getFirstName() != null && !teacherUpdateRequest.getFirstName().isEmpty()) {
			if(!teacherUpdateRequest.getFirstName().equals(teacher.getFirstName())){
				teacher.setFirstName(teacherUpdateRequest.getFirstName());
			}
		}
		if(teacherUpdateRequest.getLastName() != null && !teacherUpdateRequest.getLastName().isEmpty()) {
			if(!teacherUpdateRequest.getLastName().equals(teacher.getLastName())){
				teacher.setLastName(teacherUpdateRequest.getLastName());
			}
		}
		if(teacherUpdateRequest.getMobile() != null && !teacherUpdateRequest.getMobile().isEmpty()) {
			if(!teacherUpdateRequest.getMobile().equals(teacher.getMobile())) {
				teacher.setMobile(teacherUpdateRequest.getMobile());
			}
		}
		if(teacherUpdateRequest.getPhone() != null && teacherUpdateRequest.getPhone().isEmpty()) {
			if(!teacherUpdateRequest.getPhone().equals(teacher.getPhone())) {
				teacher.setPhone(teacherUpdateRequest.getPhone());
			}
		}
		if(teacherUpdateRequest.getDob() != null ) {
			if(!teacherUpdateRequest.getDob().equals(teacher.getDob())) {
				teacher.setDob(teacherUpdateRequest.getDob());
			}
		}
		
		if(teacherUpdateRequest.getLastLoginDate() != null) {
			if(!teacherUpdateRequest.getLastLoginDate().equals(teacher.getLastLoginDate())) {
				teacher.setLastLoginDate(teacherUpdateRequest.getLastLoginDate());
			}
		}
		if(teacherUpdateRequest.getLastLoginIp() != null && teacherUpdateRequest.getLastLoginIp().isEmpty()) {
			if(!teacherUpdateRequest.getLastLoginIp().equals(teacher.getLastLoginIp())) {
				teacher.setLastLoginIp(teacherUpdateRequest.getLastLoginIp());
			}
		}
		response.put(true, teacher);
		return response;
	}
}

