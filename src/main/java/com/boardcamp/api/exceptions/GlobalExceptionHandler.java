package com.boardcamp.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({ GameConflictException.class })
	public ResponseEntity<String> handleUserNotFound(GameConflictException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
	}

	@ExceptionHandler({ CustomerConflictException.class })
	public ResponseEntity<String> handleUserNameConflict(CustomerConflictException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
	}

	@ExceptionHandler({ CustomerNotFoundException.class })
	public ResponseEntity<String> handleUserNotFound(CustomerNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
}