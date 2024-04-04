package com.boardcamp.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data // getters e setters
@AllArgsConstructor
public class CustomerDTO {

	@NotBlank
	private String name;

	@NotBlank
	@Size(min = 11, max = 11, message = "The length must be 11 characters!")
	private String cpf;

}
