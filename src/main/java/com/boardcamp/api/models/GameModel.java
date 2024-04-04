package com.boardcamp.api.models;

import com.boardcamp.api.dtos.GameDTO;

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
@Table(name = "tb_games") 
public class GameModel {

	public GameModel(GameDTO dto) {
		this.name = dto.getName();
		this.image = dto.getImage();
		this.stockTotal = dto.getStockTotal();
		this.pricePerDay = dto.getPricePerDay();
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long id;

	@Column(length = 180, nullable = false) 
	private String name;

	@Column(nullable = false)
	private String image;
	
	@Column(nullable = false)
	private Long stockTotal;

	@Column(nullable = false)
	private Long pricePerDay;

}