package com.sms.services;

import org.springframework.http.ResponseEntity;

import com.sms.dto.requests.UserRequest;
import com.sms.dto.responses.ResponseDTO;
import com.sms.dto.responses.UserResponse;

public interface UserService {

	ResponseEntity<ResponseDTO> addUser(UserRequest userRequest);

	ResponseEntity<ResponseDTO> updateUser(UserRequest userRequest, Long id);
	
	ResponseEntity<ResponseDTO> getAllUsers();
	
	ResponseEntity<ResponseDTO> getUserById(Long id);
	
	ResponseEntity<ResponseDTO> deleteUserById(Long id);
	
	ResponseEntity<ResponseDTO> getLoggedInUser(UserResponse user);

}
