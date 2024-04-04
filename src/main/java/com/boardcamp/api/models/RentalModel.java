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
@Entity 
@Table(name = "tb_rentals") 
public class RentalModel {

	public RentalModel(RentalDTO dto, CustomerModel customer, GameModel game){
		this.daysRented = dto.getDaysRented();
		this.rentDate = LocalDate.now(); 
		this.returnDate = null;
		this.originalPrice = game.getPricePerDay() * dto.getDaysRented(); 
		this.delayFee = 0L; 
		this.customer = customer;
		this.game = game;
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long id;

	@Temporal(TemporalType.DATE)
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