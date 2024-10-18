package com.shahinkhalajestani.customerproducttask.service.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderServiceModel {

	private String productId;

	private String customerId;

	private Long amount;

	private int quantity;

}
