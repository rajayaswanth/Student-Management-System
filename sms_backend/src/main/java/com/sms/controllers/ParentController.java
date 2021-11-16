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

import com.sms.dto.requests.ParentRequest;
import com.sms.dto.requests.ParentUpdateRequest;
import com.sms.dto.responses.ResponseDTO;
import com.sms.services.ParentService;

@RestController
public class ParentController {
	
	@Autowired
	ParentService parentService;
	
	@PostMapping("/parent")
	ResponseEntity<ResponseDTO> addParent(@RequestBody @Valid ParentRequest req) {
		return parentService.addParent(req);
	}
	
	@PutMapping("/parent/{id}")
	ResponseEntity<ResponseDTO> updateParent(@PathVariable Integer id, @RequestBody @Valid ParentUpdateRequest req) {
		return parentService.updateParent(id, req);
	}
	
	@GetMapping("/parent/{id}")
	ResponseEntity<ResponseDTO> getParentById(@PathVariable Integer id) {
		return parentService.getParentById(id);
	}
	
	@GetMapping("/parent")
	ResponseEntity<ResponseDTO> getAllParents() {
		return parentService.getAllParents();
	}
	
	@DeleteMapping("/parent/{id}")
	ResponseEntity<ResponseDTO> deleteParentById(@PathVariable Integer id) {
		return parentService.deleteParentById(id);
	}

}
