package com.shahinkhalajestani.customerproducttask.service.customer.impl;

import com.shahinkhalajestani.customerproducttask.base.exception.DuplicateRecordException;
import com.shahinkhalajestani.customerproducttask.base.exception.RecordNotFoundException;
import com.shahinkhalajestani.customerproducttask.model.customer.Address;
import com.shahinkhalajestani.customerproducttask.model.customer.Customer;
import com.shahinkhalajestani.customerproducttask.model.customer.dao.CustomerDao;
import com.shahinkhalajestani.customerproducttask.service.customer.CustomerService;
import com.shahinkhalajestani.customerproducttask.service.customer.mapper.CustomerServiceMapper;
import com.shahinkhalajestani.customerproducttask.service.customer.model.AddressServiceModel;
import com.shahinkhalajestani.customerproducttask.service.customer.model.CustomerServiceModel;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


	private final CustomerDao customerDao;

	private final CustomerServiceMapper serviceMapper;


	@Override
	@Transactional
	public void signUpCustomer(CustomerServiceModel customerServiceModel) {
		log.info("Going to save customer with national code : {}", customerServiceModel.getNationalCode());
		var customer = serviceMapper.toCustomer(customerServiceModel);
		try {
			customerDao.save(customer);
		} catch (ConstraintViolationException e) {
			throw new DuplicateRecordException("Customer already exists");
		}
	}

	@Override
	public CustomerServiceModel getCustomer(String customerId) {
		log.info("Going to get customer with customer id : {}", customerId);
		var customer = findCustomer(customerId);
		var addresses = customer.getAddresses().stream().map(Address::getFullAddress).toList();
		return serviceMapper.toCustomerServiceModel(customer, addresses);
	}

	private Customer findCustomer(String customerId) {
		return customerDao.findByCustomerId(customerId)
				.orElseThrow(() -> new RecordNotFoundException("customer not found with customer Id" + customerId));
	}

	@Override
	@Transactional
	public void addCustomerAddress(AddressServiceModel addressServiceModel, String customerId) {
		log.info("Going to save customer address with customer id : {}", customerId);
		var customer = findCustomer(customerId);
		var address = serviceMapper.toAddress(addressServiceModel);
		customer.addAddress(address);
		customerDao.save(customer);
	}
}
