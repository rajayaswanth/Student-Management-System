package com.sms.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.dto.requests.TeacherRequest;
import com.sms.dto.requests.TeacherUpdateRequest;
import com.sms.dto.responses.ResponseDTO;
import com.sms.services.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	 private TeacherService teacherService;
	
	@PostMapping("/teacher")
	public ResponseEntity<ResponseDTO> addTeacher(@RequestBody @Valid TeacherRequest request){
		return teacherService.addTeacher(request);
	}
	
	@PutMapping("/teacher/{id}")
	public ResponseEntity<ResponseDTO> updateTeacher(@PathVariable Integer id, @RequestBody TeacherUpdateRequest request){
		return teacherService.updateTeacher(id, request);
	}
	
	@GetMapping("/teacher/{id}")
	public ResponseEntity<ResponseDTO> getTeacherById(@PathVariable Integer id){
		return teacherService.getTeacherById(id);
	}
	
	@GetMapping("/teacher")
	public ResponseEntity<ResponseDTO> getAllParents(){
		return teacherService.getAllTeachers();
	}
	
	@DeleteMapping("/teacher/{id}")
	public ResponseEntity<ResponseDTO> deleteeTeacherById(@PathVariable Integer id){
		return teacherService.deleteTeacherById(id);
	}
}
