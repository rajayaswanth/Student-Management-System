package com.sms.services;

import org.springframework.http.ResponseEntity;

import com.sms.dto.requests.TeacherRequest;
import com.sms.dto.requests.TeacherUpdateRequest;
import com.sms.dto.responses.ResponseDTO;

public interface TeacherService {
	
	ResponseEntity<ResponseDTO> addTeacher(TeacherRequest request);

	ResponseEntity<ResponseDTO> updateTeacher(Integer id, TeacherUpdateRequest teacherUpdateRquest);
	
	ResponseEntity<ResponseDTO> getTeacherById(Integer id);
	
	ResponseEntity<ResponseDTO> getAllTeachers();
	
	ResponseEntity<ResponseDTO> deleteTeacherById(Integer id);
}
