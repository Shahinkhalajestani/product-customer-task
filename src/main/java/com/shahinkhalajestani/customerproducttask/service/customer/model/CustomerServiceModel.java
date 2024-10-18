package com.shahinkhalajestani.customerproducttask.service.customer.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceModel {

	private String customerId;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private String nationalCode;

	private List<String> addresses;
}
