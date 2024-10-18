package com.shahinkhalajestani.customerproducttask.web.product.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanySaveDto {

	@NotBlank
	private String name;

	private String description;
}
