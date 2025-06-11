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
    	System.out.println("Excption occurs");
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    // the handleGlobalException() method in global Exception serves as a catch-all mechanism for handling all unexpecting exceptions.
    // which are not specifically handle by other @ExceptionHandler methods
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex){
    	return new ResponseEntity<>("an unexpected error occurred"+ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
