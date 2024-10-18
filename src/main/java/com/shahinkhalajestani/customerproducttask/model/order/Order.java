package com.shahinkhalajestani.customerproducttask.model.order;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders", indexes = {
		@Index(name = "customer_product_ids_idx", columnList = "product_id, customer_id"),
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_id", nullable = false)
	private String productId;


	@Column(name = "customer_id", nullable = false)
	private String customerId;


	@Column(name = "order_date")
	private LocalDateTime orderDate;

	@Column(name = "amount")
	private Long amount;

	@Column(name = "quantity")
	private int quantity;

}
