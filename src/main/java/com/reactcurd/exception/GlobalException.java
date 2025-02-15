package com.reactcurd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(EmployeeCreationException.class)
	public ResponseEntity<String> handleEmployeeCreationException(EmployeeCreationException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> EmployeeNotFound(ResourceNotFoundException ex){
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
