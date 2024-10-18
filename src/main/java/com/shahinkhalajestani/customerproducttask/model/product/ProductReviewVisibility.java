package com.shahinkhalajestani.customerproducttask.model.product;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductReviewVisibility {

	NONE(0),
	BUYERS(1),
	EVERY_ONE(2);


	private final int value;

}
