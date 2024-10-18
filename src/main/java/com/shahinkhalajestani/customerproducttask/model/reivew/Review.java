package com.shahinkhalajestani.customerproducttask.model.reivew;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "reviews", indexes = {
		@Index(name = "product_id_idx", columnList = "product_id"),
		@Index(name = "customer_id_idx", columnList = "customer_id")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_id", nullable = false)
	private String productId;

	@Column(name = "customer_id", nullable = false)
	private String customerId;


	private String comment;


	@Enumerated(EnumType.STRING)
	private Vote vote;

	@Column(name = "review_date", nullable = false)
	private LocalDateTime reviewDate;

}
