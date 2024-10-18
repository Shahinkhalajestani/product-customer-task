package com.shahinkhalajestani.customerproducttask.model.product;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {

	Optional<Product> findByProductId(String productId);


	Optional<Product> findByProductIdAndVisibleIsTrue(String productId);

}
