package com.shahinkhalajestani.customerproducttask.base.exception;


import com.shahinkhalajestani.customerproducttask.base.model.ResultStatus;

public class InvalidParameterException extends ServiceBasicException {
	public InvalidParameterException(String message) {
		super(message);
	}

	@Override
	public ResultStatus getStatus() {
		return ResultStatus.INVALID_PARAMETER;
	}
}
