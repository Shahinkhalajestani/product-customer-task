package com.shahinkhalajestani.customerproducttask.web.review.dto;

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
public class ReviewResponseModel extends ResponseModel {
	private List<ReviewDto> reviews;
}
