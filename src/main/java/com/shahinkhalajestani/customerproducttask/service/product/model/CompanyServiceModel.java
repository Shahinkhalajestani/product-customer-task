package com.shahinkhalajestani.customerproducttask.service.product.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyServiceModel {

	private String name;

	private String description;

	private List<String> products;

}
