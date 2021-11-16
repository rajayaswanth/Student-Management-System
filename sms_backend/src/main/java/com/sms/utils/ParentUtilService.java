package com.sms.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dto.requests.ParentRequest;
import com.sms.dto.requests.ParentUpdateRequest;
import com.sms.dto.responses.ParentResponse;
import com.sms.entities.Parent;
import com.sms.repositories.ParentRepository;

@Service
public class ParentUtilService {
	
	@Autowired
	ParentRepository parentRepo;
	
	public Parent convertParentReqToParent(ParentRequest req) {
		Parent parent = new Parent();
		parent.setDob(req.getDob());
		parent.setFirstName(req.getFirstName());
		parent.setLastName(req.getLastName());
		parent.setMobile(req.getMobile());
		parent.setPhone(req.getPhone());
		parent.setStatus(true);
		return parent;
	}
	
	public ParentResponse convertParentObjectToParentRes(Parent parent) {
		ParentResponse response = new ParentResponse();
		response.setDob(parent.getDob());
		response.setFirstName(parent.getFirstName());
		response.setId(parent.getId());
		response.setLastName(parent.getLastName());
		response.setMobile(parent.getMobile());
		response.setPhone(parent.getPhone());
		response.setStatus(parent.getStatus());
		return response;
	}
	
	public Optional<Parent> isParentWithIdExists(Integer id) {
		return parentRepo.findById(id);
	}
	
	public Map<Boolean, Parent> canUpdate(ParentUpdateRequest req, Parent parent) {
		Map<Boolean, Parent> response = new HashMap<>();
		if(req.getFirstName() != null && !req.getFirstName().isEmpty()) {
			if(!req.getFirstName().equals(parent.getFirstName())) {
				parent.setFirstName(req.getFirstName());
			}
		}
		if(req.getLastName() != null && !req.getLastName().isEmpty()) {
			if(!req.getLastName().equals(parent.getLastName())) {
				parent.setLastName(req.getLastName());
			}
		}
		if(req.getMobile() != null && !req.getMobile().isEmpty()) {
			if(!req.getMobile().equals(parent.getMobile())) {
				parent.setMobile(req.getMobile());
			}
		}
		if(req.getPhone() != null && !req.getPhone().isEmpty()) {
			if(!req.getPhone().equals(parent.getPhone())) {
				parent.setPhone(req.getPhone());
			}
		}
		if(req.getDob() != null) {
			if(!req.getDob().equals(parent.getDob())) {
				parent.setDob(req.getDob());
			}
		}
		response.put(true, parent);
		return response;
	}

}
