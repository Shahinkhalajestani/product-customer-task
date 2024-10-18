package com.shahinkhalajestani.customerproducttask.web.product.mapper;

import com.shahinkhalajestani.customerproducttask.base.model.ResultStatus;
import com.shahinkhalajestani.customerproducttask.service.product.model.CompanyServiceModel;
import com.shahinkhalajestani.customerproducttask.service.product.model.ProductServiceModel;
import com.shahinkhalajestani.customerproducttask.web.product.dto.CompanyResponseDto;
import com.shahinkhalajestani.customerproducttask.web.product.dto.CompanySaveDto;
import com.shahinkhalajestani.customerproducttask.web.product.dto.ProductResponseDto;
import com.shahinkhalajestani.customerproducttask.web.product.dto.ProductSaveDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, imports = { ResultStatus.class })
public interface ProductResourceMapper {

	@Mapping(target = "productId", ignore = true)
	ProductServiceModel toProductServiceModel(ProductSaveDto productSaveDto);

	@Mapping(target = "products", ignore = true)
	CompanyServiceModel toCompanyServiceModel(CompanySaveDto companySaveDto);

	@BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
	@Mapping(target = "resultStatus", expression = "java(ResultStatus.SUCCESS)")
	ProductResponseDto toProductResponseDto(ProductServiceModel productServiceModel);

	@BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
	@Mapping(target = "resultStatus", expression = "java(ResultStatus.SUCCESS)")
	CompanyResponseDto toCompanyResponseDto(CompanyServiceModel companyServiceModel);
}
