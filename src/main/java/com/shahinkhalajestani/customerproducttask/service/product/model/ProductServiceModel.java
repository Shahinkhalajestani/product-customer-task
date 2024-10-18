package com.shahinkhalajestani.customerproducttask.service.product.model;

import com.shahinkhalajestani.customerproducttask.model.product.ProductReviewVisibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductServiceModel {

	private Long productId;

	private String name;

	private String description;

	private boolean visible;

	private String company;

	private ProductReviewVisibility reviewVisibility;
}
