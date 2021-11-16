package com.sms.errors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@SuppressWarnings("rawtypes")
public class ControllerAdviceErrorHandling {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationFailedResponse onConstraintValidationException(ConstraintViolationException e) {
		ValidationFailedResponse error = new ValidationFailedResponse();
		for (ConstraintViolation violation: e.getConstraintViolations()) {
			error.getViolations().add(new ValidationErrors(violation.getPropertyPath().toString(), violation.getMessage()));
		}
		return error;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	ValidationFailedResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		ValidationFailedResponse error = new ValidationFailedResponse();
		for (FieldError fieldError: e.getBindingResult().getFieldErrors()) {
			error.getViolations().add(new ValidationErrors(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		return error;
	}

}
