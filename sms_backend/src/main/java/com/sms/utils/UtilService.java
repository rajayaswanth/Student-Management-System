package com.sms.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sms.dto.responses.MetaData;
import com.sms.dto.responses.ResponseDTO;

@Service
public class UtilService {
	
	public ResponseEntity<ResponseDTO> successResponse(String message, Object data, MetaData metaData) {
		ResponseDTO response = new ResponseDTO();
		response.setStatus("SUCCESS");
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage(message);
		response.setData(data);
		response.setError(null);
		response.setMeta(metaData);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseDTO> errorResponse(String message, Object error, HttpStatus errorType) {
		ResponseDTO response = new ResponseDTO();
		response.setStatus("ERROR");
		response.setStatusCode(errorType.value());
		response.setMessage(message);
		response.setData(null);
		response.setError(error);
		response.setMeta(null);
		return new ResponseEntity<ResponseDTO>(response, errorType);
	}

}
