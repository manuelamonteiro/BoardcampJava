package com.boardcamp.api.services;

import org.springframework.stereotype.Service;

import com.boardcamp.api.dtos.CustomerDTO;
import com.boardcamp.api.exceptions.CustomerConflictException;
import com.boardcamp.api.exceptions.CustomerNotFoundException;
import com.boardcamp.api.models.CustomerModel;
import com.boardcamp.api.repositories.CustomerRepository;

import lombok.NonNull;

@Service
public class CustomerService {

	final CustomerRepository customerRepository;

	CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public CustomerModel findById(@NonNull Long id) {
		return customerRepository.findById(id).orElseThrow(
			() -> new CustomerNotFoundException("User not found!"));
	}

	public CustomerModel save(CustomerDTO dto) {
		if (customerRepository.existsByCpf(dto.getCpf())) {
			throw new CustomerConflictException("Customer already registered!");
		}

		CustomerModel customer = new CustomerModel(dto);
		return customerRepository.save(customer);
	}
}