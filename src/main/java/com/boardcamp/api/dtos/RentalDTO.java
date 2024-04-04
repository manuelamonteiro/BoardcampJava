package com.boardcamp.api.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RentalDTO {

	@NotNull
	@Positive(message = "Must be greater than 0!")
	private Long daysRented;

	@NotNull
	private Long customerId;

	@NotNull
	private Long gameId;

}
