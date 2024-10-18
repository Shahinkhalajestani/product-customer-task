package com.shahinkhalajestani.customerproducttask.service.order.mapper;

import java.time.LocalDateTime;

import com.shahinkhalajestani.customerproducttask.model.order.Order;
import com.shahinkhalajestani.customerproducttask.service.order.model.OrderServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, imports = { LocalDateTime.class })
public interface OrderServiceMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "orderDate", expression = "java(LocalDateTime.now())")
	Order toOrder(OrderServiceModel orderServiceModel);

	OrderServiceModel toOrderModel(Order order);

}
