package com.shahinkhalajestani.customerproducttask.web.product.dto;

import com.shahinkhalajestani.customerproducttask.base.model.ResponseModel;
import com.shahinkhalajestani.customerproducttask.model.product.ProductReviewVisibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProductResponseDto extends ResponseModel {

	private Long productId;

	private String name;

	private String description;

	private boolean visible;

	private String company;

	private ProductReviewVisibility reviewVisibility;

}
