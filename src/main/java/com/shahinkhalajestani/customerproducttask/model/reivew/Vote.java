package com.shahinkhalajestani.customerproducttask.model.reivew;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Vote {

	VERY_WEAK(0),
	WEAK(1),
	OK(2),
	GOOD(3),
	EXCELLENT(4);


	private final int value;

}
