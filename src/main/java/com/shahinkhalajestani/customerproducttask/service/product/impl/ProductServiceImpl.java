package com.shahinkhalajestani.customerproducttask.service.product.impl;

import com.shahinkhalajestani.customerproducttask.base.exception.DuplicateRecordException;
import com.shahinkhalajestani.customerproducttask.base.exception.RecordNotFoundException;
import com.shahinkhalajestani.customerproducttask.model.product.Company;
import com.shahinkhalajestani.customerproducttask.model.product.CompanyDao;
import com.shahinkhalajestani.customerproducttask.model.product.Product;
import com.shahinkhalajestani.customerproducttask.model.product.ProductDao;
import com.shahinkhalajestani.customerproducttask.model.product.ProductReviewVisibility;
import com.shahinkhalajestani.customerproducttask.service.product.ProductService;
import com.shahinkhalajestani.customerproducttask.service.product.mapper.ProductServiceMapper;
import com.shahinkhalajestani.customerproducttask.service.product.model.CompanyServiceModel;
import com.shahinkhalajestani.customerproducttask.service.product.model.ProductServiceModel;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao;

	private final CompanyDao companyDao;

	private final ProductServiceMapper serviceMapper;


	@Override
	@Transactional
	public void addCompany(CompanyServiceModel companyServiceModel) {
		log.info("Going to add company with name : {}", companyServiceModel.getName());
		var company = serviceMapper.toCompany(companyServiceModel);
		try {
			companyDao.save(company);
		} catch (ConstraintViolationException e) {
			throw new DuplicateRecordException("company already exists");
		}
	}

	@Override
	public void addProduct(ProductServiceModel productServiceModel) {
		log.info("Going to add product with name : {}", productServiceModel.getName());
		var product = serviceMapper.toProduct(productServiceModel);
		var company = findCompany(productServiceModel.getCompany());
		company.addProduct(product);
		companyDao.save(company);
	}

	private Company findCompany(String companyName) {
		return companyDao.findByName(companyName).orElseThrow(() -> new RecordNotFoundException("Company not found with name : " + companyName));
	}

	@Override
	public CompanyServiceModel getCompany(String name) {
		log.info("Going to find company with name : {}", name);
		var company = findCompany(name);
		return serviceMapper.toCompanyServiceModel(company);
	}

	@Override
	public ProductServiceModel getProduct(String productId) {
		log.info("Going to find product with id : {}", productId);
		var product = findProduct(productId);
		return serviceMapper.toProductServiceModel(product);
	}

	private Product findProduct(String productId) {
		return productDao.findByProductId(productId).orElseThrow(() -> new RecordNotFoundException("Product not found with id : " + productId));
	}

	@Override
	public void updateProductCondition(String productId, ProductReviewVisibility productReviewVisibility, boolean visibility) {
		log.info("Going to update product with id : {}", productId);
		var product = findProduct(productId);
		product.setReviewVisibility(productReviewVisibility);
		product.setVisible(visibility);
		productDao.save(product);
	}
}
