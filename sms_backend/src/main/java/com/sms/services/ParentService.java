package com.sms.services;

import org.springframework.http.ResponseEntity;

import com.sms.dto.requests.ParentRequest;
import com.sms.dto.requests.ParentUpdateRequest;
import com.sms.dto.responses.ResponseDTO;

public interface ParentService {

	ResponseEntity<ResponseDTO> addParent(ParentRequest req);

	ResponseEntity<ResponseDTO> updateParent(Integer id, ParentUpdateRequest req);

	ResponseEntity<ResponseDTO> getParentById(Integer id);

	ResponseEntity<ResponseDTO> getAllParents();

	ResponseEntity<ResponseDTO> deleteParentById(Integer id);

}
