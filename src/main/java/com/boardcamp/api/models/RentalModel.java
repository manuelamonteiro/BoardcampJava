package com.boardcamp.api.models;

import java.time.LocalDate;

import com.boardcamp.api.dtos.RentalDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Indica ao banco que isso é uma entidade a ser mapeada
@Table(name = "tb_rentals") // Permite escolher o nome da tabela
public class RentalModel {

	public RentalModel(RentalDTO dto, CustomerModel customer, GameModel game){
		this.daysRented = dto.getDaysRented();
		this.rentDate = LocalDate.now(); // Definindo a data atual como rentDate
		this.returnDate = null; // Definindo returnDate como null
		this.originalPrice = game.getPricePerDay() * dto.getDaysRented(); // Definindo originalPrice como 0
		this.delayFee = 0L; // Definindo delayFee como 0
		this.customer = customer;
		this.game = game;
	}

	@Id // Identifica que é o id, a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Estratégia gerar IDs
	private Long id;

	@Temporal(TemporalType.DATE) // Usado para mapear campos de data
	@Column(nullable = false)
	private LocalDate rentDate;

	@Column(nullable = false)
	private Long daysRented;

	@Temporal(TemporalType.DATE)
	@Column
	private LocalDate returnDate;

	@Column(nullable = false)
	private Long originalPrice;

	@Column(nullable = false)
	private Long delayFee;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private CustomerModel customer;

	@ManyToOne
	@JoinColumn(name = "gameId")
	private GameModel game;

}