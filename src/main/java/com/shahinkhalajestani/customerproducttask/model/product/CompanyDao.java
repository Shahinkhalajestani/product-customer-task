package com.shahinkhalajestani.customerproducttask.model.product;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company, Long> {

	Optional<Company> findByName(String name);

}
