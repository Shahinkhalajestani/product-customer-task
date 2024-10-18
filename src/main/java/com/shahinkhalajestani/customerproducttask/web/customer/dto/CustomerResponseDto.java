package com.shahinkhalajestani.customerproducttask.web.customer.dto;

import java.util.List;

import com.shahinkhalajestani.customerproducttask.base.model.ResponseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerResponseDto extends ResponseModel {

	private String customerId;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private String nationalCode;

	private List<String> addresses;

}
