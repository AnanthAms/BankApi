package com.example.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(AgeException.class)
	public ResponseEntity<String> res(Exception ae){
		return new ResponseEntity<>(ae.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AgeNotFoundException.class)
	public ResponseEntity<String> re(Exception a){
		return new ResponseEntity<>(a.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler(AccTypeNotFoundException.class)
	public ResponseEntity<String> av(Exception ab){
		return new ResponseEntity<>(ab.getMessage(),HttpStatus.OK);
	}
}
