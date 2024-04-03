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
@Entity // Indica ao banco que isso é uma entidade a ser mapeada
@Table(name = "tb_customers") // Permite escolher o nome da tabela
public class CustomerModel {

	public CustomerModel(CustomerDTO dto) {
		this.name = dto.getName();
		this.cpf = dto.getCpf();
	}

	@Id // Identifica que é o id, a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Estratégia gerar IDs
	private Long id;

	@Column(nullable = false) // Coluna da tabela + constraints
	private String name;

	@Column(length = 11, nullable = false)
	private String cpf;

}