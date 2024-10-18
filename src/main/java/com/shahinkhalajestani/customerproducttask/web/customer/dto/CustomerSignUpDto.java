package com.shahinkhalajestani.customerproducttask.web.customer.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSignUpDto {

	private String firstName;

	private String lastName;

	private String email;

	@NotBlank
	private String phoneNumber;

	@NotBlank
	private String nationalCode;

}
