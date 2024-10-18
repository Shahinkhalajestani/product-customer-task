package com.shahinkhalajestani.customerproducttask.web.customer.mapper;

import com.shahinkhalajestani.customerproducttask.base.model.ResultStatus;
import com.shahinkhalajestani.customerproducttask.service.customer.model.AddressServiceModel;
import com.shahinkhalajestani.customerproducttask.service.customer.model.CustomerServiceModel;
import com.shahinkhalajestani.customerproducttask.web.customer.dto.CustomerAddressDto;
import com.shahinkhalajestani.customerproducttask.web.customer.dto.CustomerResponseDto;
import com.shahinkhalajestani.customerproducttask.web.customer.dto.CustomerSignUpDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, imports = { ResultStatus.class })
public interface CustomerResourceMapper {

	@Mapping(target = "customerId", ignore = true)
	@Mapping(target = "addresses", ignore = true)
	CustomerServiceModel toCustomerServiceModel(CustomerSignUpDto customerSignUpDto);


	@BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
	@Mapping(target = "resultStatus", expression = "java(ResultStatus.SUCCESS)")
	CustomerResponseDto toCustomerResponseDto(CustomerServiceModel customerServiceModel);


	AddressServiceModel toAddressServiceModel(CustomerAddressDto customerAddressDto);

}
