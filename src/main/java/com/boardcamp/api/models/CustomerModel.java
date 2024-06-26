package com.boardcamp.api.models;

import com.boardcamp.api.dtos.CustomerDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_customers")
public class CustomerModel {

	public CustomerModel(CustomerDTO dto) {
		this.name = dto.getName();
		this.cpf = dto.getCpf();
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long id;

	@Column(nullable = false) 
	private String name;

	@Column(length = 11, nullable = false)
	private String cpf;

}