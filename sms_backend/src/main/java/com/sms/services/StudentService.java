package com.sms.services;

import org.springframework.http.ResponseEntity;

import com.sms.dto.requests.StudentRequest;
import com.sms.dto.requests.StudentUpdateRequest;
import com.sms.dto.responses.ResponseDTO;

public interface StudentService {

	ResponseEntity<ResponseDTO> addStudent(StudentRequest request);
	
	ResponseEntity<ResponseDTO> updateStudent(Integer id, StudentUpdateRequest req);

	ResponseEntity<ResponseDTO> getStudentById(Integer id);

	ResponseEntity<ResponseDTO> getAllStudents();

	ResponseEntity<ResponseDTO> deleteStudentById(Integer id);
}
