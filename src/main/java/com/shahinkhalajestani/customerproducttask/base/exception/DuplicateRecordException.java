package com.shahinkhalajestani.customerproducttask.base.exception;


import com.shahinkhalajestani.customerproducttask.base.model.ResultStatus;

public class DuplicateRecordException extends ServiceBasicException {
	public DuplicateRecordException(String message) {
		super(message);
	}

	@Override
	public ResultStatus getStatus() {
		return ResultStatus.DUPLICATE_RECORD;
	}
}
