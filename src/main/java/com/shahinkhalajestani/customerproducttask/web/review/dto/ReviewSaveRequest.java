package com.shahinkhalajestani.customerproducttask.web.review.dto;

import com.shahinkhalajestani.customerproducttask.model.reivew.Vote;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewSaveRequest {


	@NotBlank
	private String productId;

	@NotBlank
	private String customerId;

	private String comment;

	@NotNull
	private Vote vote;

}
