package com.shahinkhalajestani.customerproducttask.web.order.mapper;

import com.shahinkhalajestani.customerproducttask.service.order.model.OrderServiceModel;
import com.shahinkhalajestani.customerproducttask.web.order.dto.OrderSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface OrderResourceMapper {

	@Mapping(target = "amount", ignore = true)
	OrderServiceModel toOrderServiceModel(OrderSaveDto orderSaveDto);

}
