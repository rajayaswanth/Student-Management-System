package com.sms.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sms.dto.requests.StudentRequest;
import com.sms.dto.requests.StudentUpdateRequest;
import com.sms.dto.responses.ResponseDTO;
import com.sms.services.StudentService;

@Controller
public class StudentController {

	
	private StudentService studentService;
	
	@PostMapping("/student")
	ResponseEntity<ResponseDTO> addStudent(@RequestBody @Valid StudentRequest req) {
		return studentService.addStudent(req);
	}
	
	@PutMapping("/student/{id}")
	ResponseEntity<ResponseDTO> updateStudent(@PathVariable Integer id, @RequestBody @Valid StudentUpdateRequest req) {
		return studentService.updateStudent(id, req);
	}
	
	@GetMapping("/student/{id}")
	ResponseEntity<ResponseDTO> getStudentById(@PathVariable Integer id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/student")
	ResponseEntity<ResponseDTO> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@DeleteMapping("/student/{id}")
	ResponseEntity<ResponseDTO> deleteStudentById(@PathVariable Integer id) {
		return studentService.deleteStudentById(id);
	}
}
