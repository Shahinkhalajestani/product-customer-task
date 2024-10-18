package com.shahinkhalajestani.customerproducttask.web.product;

import com.shahinkhalajestani.customerproducttask.base.model.ResponseModel;
import com.shahinkhalajestani.customerproducttask.service.product.ProductService;
import com.shahinkhalajestani.customerproducttask.web.product.dto.CompanyResponseDto;
import com.shahinkhalajestani.customerproducttask.web.product.dto.CompanySaveDto;
import com.shahinkhalajestani.customerproducttask.web.product.dto.ProductResponseDto;
import com.shahinkhalajestani.customerproducttask.web.product.dto.ProductSaveDto;
import com.shahinkhalajestani.customerproducttask.web.product.dto.ProductUpdateDto;
import com.shahinkhalajestani.customerproducttask.web.product.mapper.ProductResourceMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductResource {

	private final ProductService productService;

	private final ProductResourceMapper resourceMapper;

	@GetMapping("/product/{productId}")
	public ResponseEntity<ProductResponseDto> getProduct(@PathVariable("productId") String productId) {
		log.info("Get product by id: {}", productId);
		var product = productService.getProduct(productId);
		return ResponseEntity.ok(resourceMapper.toProductResponseDto(product));
	}


	@GetMapping("/company/{name}")
	public ResponseEntity<CompanyResponseDto> getProductByCompany(@PathVariable("name") String name) {
		log.info("Get company by name: {}", name);
		var company = productService.getCompany(name);
		return ResponseEntity.ok(resourceMapper.toCompanyResponseDto(company));
	}


	@PostMapping("/company")
	public ResponseEntity<ResponseModel> saveCompany(@RequestBody @Valid CompanySaveDto companySaveDto) {
		log.info("Save company: {}", companySaveDto);
		var serviceModel = resourceMapper.toCompanyServiceModel(companySaveDto);
		productService.addCompany(serviceModel);
		return ResponseEntity.ok(ResponseModel.success());
	}


	@PostMapping("/product")
	public ResponseEntity<ResponseModel> saveProduct(@RequestBody @Valid ProductSaveDto productSaveDto) {
		log.info("Save product: {}", productSaveDto);
		var serviceModel = resourceMapper.toProductServiceModel(productSaveDto);
		productService.addProduct(serviceModel);
		return ResponseEntity.ok(ResponseModel.success());
	}


	@PutMapping("/product/update/{productId}")
	public ResponseEntity<ResponseModel> updateProduct(@PathVariable("productId") String productId,
			@RequestBody @Valid ProductUpdateDto productUpdateDto) {
		log.info("Update product: {}", productId);
		productService.updateProductCondition(productId, productUpdateDto.getReviewVisibility()
				, productUpdateDto.getVisibility());
		return ResponseEntity.ok(ResponseModel.success());
	}

}

