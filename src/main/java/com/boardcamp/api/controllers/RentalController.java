package com.boardcamp.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boardcamp.api.dtos.RentalDTO;
import com.boardcamp.api.models.RentalModel;
import com.boardcamp.api.services.RentalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rentals")
public class RentalController {

	final RentalService rentalService;

	public RentalController(RentalService rentalService) {
		this.rentalService = rentalService;
	}

	@GetMapping
	public ResponseEntity<Object> getRentals() {
		List<RentalModel> rentals = rentalService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(rentals);
	}

	@PostMapping
	public ResponseEntity<Object> createRental(@RequestBody @Valid RentalDTO body) {
		RentalModel rental = rentalService.save(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(rental);
	}

	@PutMapping("/{id}/return")
	public ResponseEntity<Object> updateRental(@PathVariable Long id) {
		RentalModel rental = rentalService.update(id);
		return ResponseEntity.status(HttpStatus.OK).body(rental);
	}

}