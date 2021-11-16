package com.sms.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sms.dto.requests.ParentRequest;
import com.sms.dto.requests.ParentUpdateRequest;
import com.sms.dto.responses.ParentResponse;
import com.sms.dto.responses.ResponseDTO;
import com.sms.entities.Parent;
import com.sms.repositories.ParentRepository;
import com.sms.services.ParentService;
import com.sms.utils.ParentUtilService;
import com.sms.utils.UtilService;

@Service
public class ParentServiceImpl implements ParentService {
	
	@Autowired
	ParentRepository parentrepo;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	ParentUtilService parentUtilService;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	public ResponseEntity<ResponseDTO> addParent(ParentRequest req) {
		Parent parent = parentUtilService.convertParentReqToParent(req);
		Parent insertedData = parentrepo.save(parent);
		return utilService.successResponse("Created Successfully", parentUtilService.convertParentObjectToParentRes(insertedData), null);
	}

	@Override
	public ResponseEntity<ResponseDTO> updateParent(Integer id, ParentUpdateRequest req) {
		Optional<Parent> parent = parentUtilService.isParentWithIdExists(id);
		if(parent.isPresent()) {
			Map<Boolean, Parent> canUpdate = parentUtilService.canUpdate(req, parent.get());
			if(canUpdate.containsKey(true)) {
				Parent updatedData = parentrepo.save(canUpdate.get(true));
				return utilService.successResponse("Updated SuccessFully", updatedData, null);
			} else {
				return utilService.errorResponse("Nothing to update", null, HttpStatus.NO_CONTENT);
			}
		} else {
			return utilService.errorResponse("Parent with Id - " + id +" doesn't exist", null, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> getParentById(Integer id) {
		Optional<Parent> parent = parentUtilService.isParentWithIdExists(id);
		if(parent.isPresent()) {
			return utilService.successResponse(null, parentUtilService.convertParentObjectToParentRes(parent.get()), null);
		} else {
			return utilService.errorResponse("Parent with Id - " + id +" doesn't exist", null, HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<ResponseDTO> getAllParents() {
		List<Parent> parents =  parentrepo.findAll();
		List<ParentResponse> response = new ArrayList<>();
		parents.stream().forEach(p -> {
			response.add(parentUtilService.convertParentObjectToParentRes(p));
		});
		return utilService.successResponse(null, response, null);
	}

	@Override
	public ResponseEntity<ResponseDTO> deleteParentById(Integer id) {
		Optional<Parent> parent = parentUtilService.isParentWithIdExists(id);
		if(parent.isPresent()) {
			parentrepo.deleteById(id);
			return utilService.successResponse("Deleted Successfully", null, null);
		} else {
			return utilService.errorResponse("Parent with Id - " + id +" doesn't exist", null, HttpStatus.BAD_REQUEST);
		}
	}

}
