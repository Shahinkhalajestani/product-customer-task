package com.shahinkhalajestani.customerproducttask.web.product.dto;

import java.util.List;

import com.shahinkhalajestani.customerproducttask.base.model.ResponseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CompanyResponseDto extends ResponseModel {

	private String name;

	private String description;

	private List<String> products;

}
