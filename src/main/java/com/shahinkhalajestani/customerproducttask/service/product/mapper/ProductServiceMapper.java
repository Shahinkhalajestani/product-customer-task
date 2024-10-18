package com.shahinkhalajestani.customerproducttask.service.product.mapper;

import java.util.List;
import java.util.Objects;

import com.shahinkhalajestani.customerproducttask.model.product.Company;
import com.shahinkhalajestani.customerproducttask.model.product.Product;
import com.shahinkhalajestani.customerproducttask.service.product.model.CompanyServiceModel;
import com.shahinkhalajestani.customerproducttask.service.product.model.ProductServiceModel;
import org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductServiceMapper {


	@Mapping(target = "id", ignore = true)
	@Mapping(target = "company", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "productId", expression = "java(java.util.UUID.randomUUID().toString())")
	Product toProduct(ProductServiceModel productServiceModel);


	@Mapping(target = "id", ignore = true)
	@Mapping(target = "products", ignore = true)
	@Mapping(target = "version", ignore = true)
	Company toCompany(CompanyServiceModel companyServiceModel);


	@Mapping(target = "company", source = "product", qualifiedByName = "toCompanyName")
	ProductServiceModel toProductServiceModel(Product product);


	@Mapping(target = "products", source = "company", qualifiedByName = "toProductIds")
	CompanyServiceModel toCompanyServiceModel(Company company);


	@Named("toProductIds")
	default List<String> toProductIds(Company company) {
		if (CollectionUtils.isNotEmpty(company.getProducts())) {
			return company.getProducts().stream().map(Product::getProductId).toList();
		} else {
			return null;
		}
	}


	@Named("toCompanyName")
	default String toCompanyName(Product product) {
		if (Objects.nonNull(product.getCompany())) {
			return product.getCompany().getName();
		} else {
			return null;
		}
	}

}
