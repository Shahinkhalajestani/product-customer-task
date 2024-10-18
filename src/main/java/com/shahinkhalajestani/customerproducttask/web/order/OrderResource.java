package com.shahinkhalajestani.customerproducttask.web.order;

import com.shahinkhalajestani.customerproducttask.base.model.ResponseModel;
import com.shahinkhalajestani.customerproducttask.service.order.OrderService;
import com.shahinkhalajestani.customerproducttask.web.order.dto.OrderSaveDto;
import com.shahinkhalajestani.customerproducttask.web.order.mapper.OrderResourceMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderResource {

	private final OrderService orderService;

	private final OrderResourceMapper resourceMapper;


	@PostMapping
	public ResponseEntity<ResponseModel> putOrder(@RequestBody @Valid OrderSaveDto orderSaveDto) {
		log.info("Going to put order for product Id : {} and customer Id : {}", orderSaveDto.getProductId(), orderSaveDto.getCustomerId());
		var serviceModel = resourceMapper.toOrderServiceModel(orderSaveDto);
		orderService.putOrder(serviceModel);
		return ResponseEntity.ok(ResponseModel.success());
	}

}
