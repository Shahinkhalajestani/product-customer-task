package com.shahinkhalajestani.customerproducttask.service.customer;

import com.shahinkhalajestani.customerproducttask.service.customer.model.AddressServiceModel;
import com.shahinkhalajestani.customerproducttask.service.customer.model.CustomerServiceModel;

public interface CustomerService {

	void signUpCustomer(CustomerServiceModel customerServiceModel);

	CustomerServiceModel getCustomer(String customerId);


	void addCustomerAddress(AddressServiceModel addressServiceModel, String customerId);

}
