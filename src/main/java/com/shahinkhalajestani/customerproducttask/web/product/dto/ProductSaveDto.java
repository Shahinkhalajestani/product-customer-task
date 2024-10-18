package com.shahinkhalajestani.customerproducttask.web.product.dto;

import com.shahinkhalajestani.customerproducttask.model.product.ProductReviewVisibility;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveDto {

	@NotBlank
	private String name;

	@NotBlank
	private String description;

	private boolean visible;

	@NotBlank
	private String company;

	@NotNull
	private ProductReviewVisibility reviewVisibility;
}
