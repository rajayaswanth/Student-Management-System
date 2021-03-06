package com.sms.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sms.dto.requests.UserRequest;
import com.sms.dto.requests.UserType;
import com.sms.dto.responses.ResponseDTO;
import com.sms.dto.responses.UserResponse;
import com.sms.entities.User;
import com.sms.repositories.ParentRepository;
import com.sms.repositories.StudentRepository;
import com.sms.repositories.TeacherRepository;
import com.sms.repositories.UserRepository;
import com.sms.services.UserService;
import com.sms.utils.UserUtilService;
import com.sms.utils.UtilService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserUtilService userUtil;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	TeacherRepository teacherRepo;
	
	@Autowired
	ParentRepository parentRepo;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public ResponseEntity<ResponseDTO> addUser(UserRequest userRequest) {
		userRequest.setPassword(encoder.encode(userRequest.getPassword()));
		if(userUtil.userWithEmailExists(userRequest.getEmail())) {
			return utilService.errorResponse("User With email - " + userRequest.getEmail() + " already exists", null, HttpStatus.BAD_REQUEST);
		}
		User user = userRepo.save(userUtil.convertUserRequestToUser(userRequest));
		if(user.getUserType().equals(UserType.TEACHER))
			teacherRepo.save(userUtil.convertUserRequestToTeacher(userRequest, user));
		else if(user.getUserType().equals(UserType.PARENT))
			parentRepo.save(userUtil.convertUserRequestToParent(userRequest, user));
		return utilService.successResponse("Created Successfully", userUtil.convertUserToUserResponse(user), null);
	}

	@Override
	public ResponseEntity<ResponseDTO> updateUser(UserRequest userRequest, Long id) {
		Optional<User> user = userUtil.isUserWithIdExists(id);
		if(user.isPresent()) {
			return utilService.successResponse(null, userUtil.convertUserToUserResponse(user.get()), null);
		} else {
			return utilService.errorResponse("Parent with Id - " + id +" doesn't exist", null, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> getAllUsers() {
		List<User> users = userRepo.findAll();
		List<UserResponse> response = new ArrayList<>();
		users.stream().forEach(u -> {
			UserResponse r = userUtil.convertUserToUserResponse(u);
			response.add(r);
		});
		return utilService.successResponse("Success", response, null);
	}

	@Override
	public ResponseEntity<ResponseDTO> getUserById(Long id) {
		User user = userRepo.getById(id);
		UserResponse response = userUtil.convertUserToUserResponse(user);
		return utilService.successResponse("Success", response, null);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteUserById(Long id) {
		userRepo.deleteById(id);
		return utilService.successResponse("Success", "deleted successfully", null);
	}

	@Override
	public ResponseEntity<ResponseDTO> getLoggedInUser(UserResponse user) {
		return utilService.successResponse("Success", user, null);
	}

}
