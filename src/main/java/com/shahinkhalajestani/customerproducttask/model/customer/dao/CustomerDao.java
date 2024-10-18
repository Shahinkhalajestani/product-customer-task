package com.shahinkhalajestani.customerproducttask.model.customer.dao;

import java.util.Optional;

import com.shahinkhalajestani.customerproducttask.model.customer.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {

	Optional<Customer> findByCustomerId(String customerId);



}
