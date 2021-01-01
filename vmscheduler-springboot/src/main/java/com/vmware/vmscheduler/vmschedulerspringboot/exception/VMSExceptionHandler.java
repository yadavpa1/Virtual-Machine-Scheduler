package com.vmware.vmscheduler.vmschedulerspringboot.exception;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class VMSExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public ResponseEntity<VMSErrorResponse> handleException(RecordNotFoundException exc){
		
		VMSErrorResponse error = new VMSErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(new Timestamp(System.currentTimeMillis()));
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<VMSErrorResponse> handleException(Exception exc){
		
		VMSErrorResponse error = new VMSErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(new Timestamp(System.currentTimeMillis()));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
