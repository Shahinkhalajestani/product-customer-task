package com.shahinkhalajestani.customerproducttask.service.enquiry.impl;

import java.util.Random;

import com.shahinkhalajestani.customerproducttask.service.enquiry.EnquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnquiryServiceImpl implements EnquiryService {

	//FIXME THIS IS NOT IMPLEMENTED AS IT WAS NOT REQUIRED IN THE TASK.
	@Override
	public Long getProductPrice(String productId) {
		var random = new Random();
		return random.nextLong();
	}
}
