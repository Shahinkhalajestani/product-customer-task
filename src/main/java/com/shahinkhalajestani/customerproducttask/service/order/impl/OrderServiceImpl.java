package com.shahinkhalajestani.customerproducttask.service.order.impl;

import com.shahinkhalajestani.customerproducttask.model.order.OrderDao;
import com.shahinkhalajestani.customerproducttask.service.customer.CustomerService;
import com.shahinkhalajestani.customerproducttask.service.enquiry.EnquiryService;
import com.shahinkhalajestani.customerproducttask.service.order.OrderService;
import com.shahinkhalajestani.customerproducttask.service.order.mapper.OrderServiceMapper;
import com.shahinkhalajestani.customerproducttask.service.order.model.OrderServiceModel;
import com.shahinkhalajestani.customerproducttask.service.product.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


	private final ProductService productService;

	private final OrderDao orderDao;

	private final CustomerService customerService;

	private final EnquiryService enquiryService;

	private final OrderServiceMapper serviceMapper;


	@Override
	@Transactional
	public void putOrder(OrderServiceModel orderServiceModel) {
		var customer = customerService.getCustomer(orderServiceModel.getCustomerId());
		log.info("Gonna put order for customer  : {}", customer.getNationalCode());
		orderServiceModel.setAmount(enquiryService.getProductPrice(orderServiceModel.getProductId()));
		var order = serviceMapper.toOrder(orderServiceModel);
		orderDao.save(order);
		productService.subtractQuantity(order.getProductId(), order.getQuantity());
	}


	@Override
	public boolean doesOrderExists(String productId, String customerId) {
		return orderDao.existsByProductIdAndCustomerId(productId, customerId);
	}
}
