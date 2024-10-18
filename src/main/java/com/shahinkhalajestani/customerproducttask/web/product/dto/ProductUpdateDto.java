package com.shahinkhalajestani.customerproducttask.web.product.dto;

import com.shahinkhalajestani.customerproducttask.model.product.ProductReviewVisibility;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDto {

	@NotNull
	private ProductReviewVisibility reviewVisibility;

	@NotNull
	private Boolean visibility;

}
