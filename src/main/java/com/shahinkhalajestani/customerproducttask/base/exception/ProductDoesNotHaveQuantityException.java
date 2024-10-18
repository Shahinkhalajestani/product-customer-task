package com.shahinkhalajestani.customerproducttask.base.exception;

import com.shahinkhalajestani.customerproducttask.base.model.ResultStatus;

public class ProductDoesNotHaveQuantityException extends ServiceBasicException {
	public ProductDoesNotHaveQuantityException(String message) {
		super(message);
	}

	@Override
	public ResultStatus getStatus() {
		return ResultStatus.PRODUCT_NOT_ENOUGH;
	}
}
