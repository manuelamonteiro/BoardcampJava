package com.boardcamp.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boardcamp.api.dtos.CustomerDTO;
import com.boardcamp.api.models.CustomerModel;
import com.boardcamp.api.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("id") Long id) {
		CustomerModel customer = customerService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	
	}

	@PostMapping
	public ResponseEntity<Object> createCustomer(@RequestBody @Valid CustomerDTO body) {
		CustomerModel customer = customerService.save(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer);
	}

}