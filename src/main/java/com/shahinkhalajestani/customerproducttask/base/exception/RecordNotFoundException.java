package com.shahinkhalajestani.customerproducttask.base.exception;


import com.shahinkhalajestani.customerproducttask.base.model.ResultStatus;

public class RecordNotFoundException extends ServiceBasicException {
	public RecordNotFoundException(String message) {
		super(message);
	}

	@Override
	public ResultStatus getStatus() {
		return ResultStatus.RECORD_NOT_FOUND;
	}
}
