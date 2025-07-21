package com.transport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.transport.dto.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exp){
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setMessage("Failure");
		res.setData(exp.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoRecordFoundException(NoRecordFoundException exp){
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setMessage("Failure");
		res.setData(exp.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);
	}
	
}
