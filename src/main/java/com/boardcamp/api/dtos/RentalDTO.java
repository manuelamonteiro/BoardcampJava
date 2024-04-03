package com.boardcamp.api.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data // getters e setters
@AllArgsConstructor
public class RentalDTO {

	@NotNull
	private Long customerId;

	@NotNull
	@Min(value = 1, message = "Days rented must be at least 1")
	private Long daysRented;

	@NotNull
	private Long gameId;
}
