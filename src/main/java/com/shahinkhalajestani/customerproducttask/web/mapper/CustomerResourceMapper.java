package com.shahinkhalajestani.customerproducttask.web.mapper;

import com.shahinkhalajestani.customerproducttask.base.model.ResponseModel;
import com.shahinkhalajestani.customerproducttask.service.model.AddressServiceModel;
import com.shahinkhalajestani.customerproducttask.service.model.CustomerServiceModel;
import com.shahinkhalajestani.customerproducttask.web.dto.CustomerAddressDto;
import com.shahinkhalajestani.customerproducttask.web.dto.CustomerResponseDto;
import com.shahinkhalajestani.customerproducttask.web.dto.CustomerSignUpDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, imports = { ResponseModel.class })
public interface CustomerResourceMapper {

	@Mapping(target = "customerId", ignore = true)
	@Mapping(target = "addresses", ignore = true)
	CustomerServiceModel toCustomerServiceModel(CustomerSignUpDto customerSignUpDto);


	@Mapping(target = "resultStatus", expression = "java(ResultStatus.SUCCESS)")
	CustomerResponseDto toCustomerResponseDto(CustomerServiceModel customerServiceModel);


	AddressServiceModel	toAddressServiceModel(CustomerAddressDto customerAddressDto);

}
