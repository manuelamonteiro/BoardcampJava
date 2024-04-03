package com.boardcamp.api.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data // getters e setters
@AllArgsConstructor
public class CustomerDTO {

	@NotNull
	private String name;

	@NotNull
	@Size(max = 11, message = "Maximum length for cpf is 11 characters!")
	private String cpf;

}
