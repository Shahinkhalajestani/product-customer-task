package com.shahinkhalajestani.customerproducttask.web;


import com.shahinkhalajestani.customerproducttask.base.model.ResponseModel;
import com.shahinkhalajestani.customerproducttask.service.CustomerService;
import com.shahinkhalajestani.customerproducttask.web.dto.CustomerAddressDto;
import com.shahinkhalajestani.customerproducttask.web.dto.CustomerSignUpDto;
import com.shahinkhalajestani.customerproducttask.web.mapper.CustomerResourceMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerResource {

	private final CustomerService customerService;

	private final CustomerResourceMapper resourceMapper;


	@PostMapping
	public ResponseEntity<ResponseModel> signUpCustomer(@RequestBody @Valid CustomerSignUpDto customerSignUpDto) {
		var serviceModel = resourceMapper.toCustomerServiceModel(customerSignUpDto);
		customerService.signUpCustomer(serviceModel);
		log.info("Customer signed up successful with national code : {}", serviceModel.getNationalCode());
		return ResponseEntity.ok(ResponseModel.success());
	}


	@GetMapping("/{customerId}")
	public ResponseEntity<ResponseModel> getCustomers(@PathVariable("customerId") String customerId) {
		log.info("Get customer with customer id : {}", customerId);
		var customer = customerService.getCustomer(customerId);
		var response = resourceMapper.toCustomerResponseDto(customer);
		return ResponseEntity.ok(response);
	}


	@PostMapping("/address/{customerId}")
	public ResponseEntity<ResponseModel> addAddress(@PathVariable("customerId") String customerId,
			@RequestBody @Valid CustomerAddressDto customerAddressDto) {
		log.info("Add customer address with customer id : {}", customerId);
		var serviceModel = resourceMapper.toAddressServiceModel(customerAddressDto);
		customerService.addCustomerAddress(serviceModel, customerId);
		log.info("Customer address added successful with customer id : {}", customerId);
		return ResponseEntity.ok(ResponseModel.success());
	}

}
