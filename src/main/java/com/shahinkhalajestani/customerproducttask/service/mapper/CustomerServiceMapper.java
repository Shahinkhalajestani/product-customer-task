package com.shahinkhalajestani.customerproducttask.service.mapper;

import java.time.LocalDateTime;
import java.util.List;

import com.shahinkhalajestani.customerproducttask.model.customer.Address;
import com.shahinkhalajestani.customerproducttask.model.customer.Customer;
import com.shahinkhalajestani.customerproducttask.service.model.AddressServiceModel;
import com.shahinkhalajestani.customerproducttask.service.model.CustomerServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, imports = { LocalDateTime.class })
public interface CustomerServiceMapper {


	@Mapping(target = "id", ignore = true)
	@Mapping(target = "addresses", ignore = true)
	@Mapping(target = "signUpDate", expression = "java(LocalDateTime.now())")
	@Mapping(target = "customerId", expression = "java(java.util.UUID.randomUUID().toString())")
	Customer toCustomer(CustomerServiceModel customerServiceModel);

	@Mapping(target = "id", ignore = true)
	Address toAddress(AddressServiceModel addressServiceModel);

	CustomerServiceModel toCustomerServiceModel(Customer customer, List<String> addresses);
}

