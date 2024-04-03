package com.boardcamp.api.models;

import com.boardcamp.api.dtos.RentalDTO;

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
@Table(name = "tb_rentals") // Permite escolher o nome da tabela
public class RentalModel {

	public RentalModel(RentalDTO dto) {
		this.customerId = dto.getCustomerId();
		this.daysRented = dto.getDaysRented();
		this.gameId = dto.getGameId();
	}

	@Id // Identifica que é o id, a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Estratégia gerar IDs
	private Long id;

	@Column(nullable = false)
	private Long customerId;

	@Column(nullable = false)
	private Long daysRented;

	@Column(nullable = false)
	private Long gameId;

}