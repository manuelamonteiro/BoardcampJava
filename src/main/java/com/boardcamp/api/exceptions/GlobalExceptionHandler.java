package com.boardcamp.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({ GameConflictException.class })
	public ResponseEntity<String> handleGameNameConflict(GameConflictException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
	}

	@ExceptionHandler({ CustomerConflictException.class })
	public ResponseEntity<String> handleCustomerNameConflict(CustomerConflictException exception) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
	}

	@ExceptionHandler({ CustomerNotFoundException.class })
	public ResponseEntity<String> handleCustomerNotFound(CustomerNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

	@ExceptionHandler({ GameNotFoundException.class })
	public ResponseEntity<String> handleGameNotFound(GameNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

	@ExceptionHandler({ RentalUnprocessableEntityException.class })
	public ResponseEntity<String> handleRentalUnprocessableEntity(RentalUnprocessableEntityException exception) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
	}
}