package com.sms.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sms.dto.requests.StudentRequest;
import com.sms.dto.requests.StudentUpdateRequest;
import com.sms.dto.responses.ResponseDTO;
import com.sms.dto.responses.StudentResponse;
import com.sms.entities.Student;
import com.sms.repositories.StudentRepository;
import com.sms.services.StudentService;
import com.sms.utils.StudentUtilService;
import com.sms.utils.UtilService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentUtilService studentUtilService;

	@Autowired
	private UtilService utilService;
	@Override
	public ResponseEntity<ResponseDTO> addStudent(StudentRequest request) {
		Student student = studentUtilService.convertStudentReqToStudent(request);
		Student insertedData = studentRepository.save(student);
		return utilService.successResponse("Created Successfully", studentUtilService.convertStudentObjectToStudentRes(insertedData), null);
	}

	@Override
	public ResponseEntity<ResponseDTO> updateStudent(Integer id, StudentUpdateRequest req) {
		Optional<Student> student = studentUtilService.isStudentWithIdExists(id);
		if(student.isPresent()) {
			Map<Boolean,Student> canUpdate = studentUtilService.canUpdate(req, student.get());
			if(canUpdate.containsKey(true)) {
				Student updatedData = studentRepository.save(canUpdate.get(true));
				return utilService.successResponse("Updated SuccessFully", updatedData, null);
			} else {
				return utilService.errorResponse("Nothing to update", null, HttpStatus.NO_CONTENT);
			}
		}
		return utilService.errorResponse("Student with Id - " + id +" doesn't exist", null, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<ResponseDTO> getStudentById(Integer id) {
		Optional<Student> student = studentUtilService.isStudentWithIdExists(id);
		if(student.isPresent()) {
			return utilService.successResponse(null, studentUtilService.convertStudentObjectToStudentRes(student.get()), null);
		} else {
			return utilService.errorResponse("Student with Id - " + id +" doesn't exist", null, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		List<StudentResponse> response = new ArrayList<>();
		students.stream().forEach(s -> {
			response.add(studentUtilService.convertStudentObjectToStudentRes(s));
		});
		return utilService.successResponse(null, response, null);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteStudentById(Integer id) {
		Optional<Student> student = studentUtilService.isStudentWithIdExists(id);
		if(student.isPresent()) {
			studentRepository.deleteById(id);
			return utilService.successResponse("Deleted Successfully", null, null);
		} else {
			return utilService.errorResponse("Student with Id - " + id +" doesn't exist", null, HttpStatus.BAD_REQUEST);
		}
	}

}
