package com.shahinkhalajestani.customerproducttask.web.customer.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddressDto {

	private String street;

	private String city;

	private String province;

	@NotBlank
	private String postalCode;

	private String houseNumber;

}
