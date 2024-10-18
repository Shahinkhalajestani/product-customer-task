package com.shahinkhalajestani.customerproducttask.service.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressServiceModel {

	private String street;

	private String city;

	private String province;

	private String postalCode;

	private String houseNumber;

}
