package com.shahinkhalajestani.customerproducttask.model.reivew.dao;

import java.util.List;

import com.shahinkhalajestani.customerproducttask.model.reivew.Review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDao extends JpaRepository<Review, Long> {

	List<Review> findAllByCustomerId(String customerId);

	List<Review> findAllByProductId(String productId);

}
