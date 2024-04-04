package com.boardcamp.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameDTO {

	@NotBlank
	@Size(max = 180, message = "Maximum length for name is 180 characters!")
	private String name;

	@NotBlank
	private String image;

	@NotNull
	@PositiveOrZero(message = "Must be equal to or greater than 0!")
	private Long stockTotal;

	@NotNull
	@Positive(message = "Must be greater than 0!")
	private Long pricePerDay;
}
