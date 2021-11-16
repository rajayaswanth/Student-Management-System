package com.sms.services;

import org.springframework.http.ResponseEntity;

import com.sms.dto.requests.UserRequest;
import com.sms.dto.responses.ResponseDTO;

public interface UserService {

	ResponseEntity<ResponseDTO> addUser(UserRequest userRequest);

}
