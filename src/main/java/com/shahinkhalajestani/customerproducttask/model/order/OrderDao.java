package com.shahinkhalajestani.customerproducttask.model.order;

import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order, Long> {

	boolean existsByProductIdAndCustomerId(String productId, String customerId);

}
