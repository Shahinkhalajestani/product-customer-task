package com.shahinkhalajestani.customerproducttask.base.exception;

import com.shahinkhalajestani.customerproducttask.base.model.ResultStatus;
import lombok.Getter;

@Getter
public class ServiceBasicException extends RuntimeException {

	private final ResultStatus status;

	public ServiceBasicException(String message) {
		super(message);
		this.status = ResultStatus.FAILURE;
	}
}
