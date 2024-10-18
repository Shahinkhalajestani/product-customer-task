package com.shahinkhalajestani.customerproducttask.service;

import com.shahinkhalajestani.customerproducttask.service.model.AddressServiceModel;
import com.shahinkhalajestani.customerproducttask.service.model.CustomerServiceModel;

public interface CustomerService {

	void signUpCustomer(CustomerServiceModel customerServiceModel);

	CustomerServiceModel getCustomer(String customerId);


	void addCustomerAddress(AddressServiceModel addressServiceModel, String customerId);

}
