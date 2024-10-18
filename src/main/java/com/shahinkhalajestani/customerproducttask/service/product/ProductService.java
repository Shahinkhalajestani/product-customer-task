package com.shahinkhalajestani.customerproducttask.service.product;

import com.shahinkhalajestani.customerproducttask.model.product.ProductReviewVisibility;
import com.shahinkhalajestani.customerproducttask.service.product.model.CompanyServiceModel;
import com.shahinkhalajestani.customerproducttask.service.product.model.ProductServiceModel;

public interface ProductService {

	void addCompany(CompanyServiceModel companyServiceModel);

	void addProduct(ProductServiceModel productServiceModel);

	CompanyServiceModel getCompany(String name);

	ProductServiceModel getProduct(String productId);

	void updateProductCondition(String productId, ProductReviewVisibility productReviewVisibility, boolean visibility);

}
