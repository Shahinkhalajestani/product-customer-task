package com.shahinkhalajestani.customerproducttask.service.order;

import com.shahinkhalajestani.customerproducttask.service.order.model.OrderServiceModel;

public interface OrderService {

	void putOrder(OrderServiceModel orderServiceModel);


	boolean doesOrderExists(String productId, String customerId);

}
