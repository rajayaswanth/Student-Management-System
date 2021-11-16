package com.sms.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sms.dto.requests.TeacherRequest;
import com.sms.dto.requests.TeacherUpdateRequest;
import com.sms.dto.responses.ResponseDTO;
import com.sms.dto.responses.TeacherResponse;
import com.sms.entities.Teacher;
import com.sms.repositories.TeacherRepository;
import com.sms.services.TeacherService;
import com.sms.utils.TeacherUtilService;
import com.sms.utils.UtilService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	UtilService utilService;

	@Autowired
	TeacherUtilService teacherUtilService;

	@Override
	public ResponseEntity<ResponseDTO> addTeacher(TeacherRequest request) {
		Teacher teacher = teacherUtilService.convertTeacherReqToTeacher(request);
		Teacher insertData = teacherRepository.save(teacher);
		return utilService.successResponse("Created Successfully", teacherUtilService.convertTeacherObjToTeacherRes(insertData),null);
	}

	@Override
	public ResponseEntity<ResponseDTO> updateTeacher(Integer id, TeacherUpdateRequest teacherUpdateRquest) {
		Optional<Teacher> teacher = teacherUtilService.isPresentWithExists(id);
		if(teacher.isPresent()) {
			Map<Boolean, Teacher> canUpdate = teacherUtilService.canUpdate(teacherUpdateRquest, teacher.get());
			if(canUpdate.containsKey(true)) {
				Teacher updateData = teacherRepository.save(canUpdate.get(true));
				return utilService.successResponse("Update Successfully", updateData, null);
			} else {
				return utilService.errorResponse("Nothing to Update", null, HttpStatus.NO_CONTENT);
			}
		} else {
			return utilService.errorResponse("Teacher with Id - " + id +" dosen't exist", null, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> getTeacherById(Integer id) {
		Optional<Teacher> teacher = teacherUtilService.isPresentWithExists(id);
		if(teacher.isPresent()) {
			return utilService.successResponse(null, teacherUtilService.convertTeacherObjToTeacherRes(teacher.get()), null);
		} else {
			return utilService.errorResponse("Teacher with Id - "+ id + " doesn't exist", HttpStatus.BAD_REQUEST, null);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> getAllTeachers() {
		List<Teacher> teacher = teacherRepository.findAll();
		List<TeacherResponse> response = new ArrayList<>();
		teacher.stream().forEach(t -> {
			response.add(teacherUtilService.convertTeacherObjToTeacherRes(t));
		});
		
		return utilService.successResponse(null, response, null);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteTeacherById(Integer id) {
		Optional<Teacher> teacher = teacherUtilService.isPresentWithExists(id);
		if(teacher.isPresent()) {
			teacherRepository.deleteById(id);
			return utilService.successResponse("Deleted Successfully", null, null);
		} else {
		return utilService.errorResponse("Teacher with Id - "+ id + " doesn't exist ", null, HttpStatus.BAD_REQUEST);
		}
	}



}
