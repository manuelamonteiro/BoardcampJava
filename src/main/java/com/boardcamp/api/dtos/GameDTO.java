package com.boardcamp.api.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data // getters e setters
@AllArgsConstructor
public class GameDTO {

	@NotNull
	@Size(max = 180, message = "Maximum length for name is 180 characters!")
	private String name;

	@NotNull
	private String image;

	@NotNull
	@Min(value = 1, message = "Stock total must be at least 1")
	private Long stockTotal;

	@NotNull
	@Min(value = 1, message = "Price per day must be at least 1")
	private Long pricePerDay;
}
