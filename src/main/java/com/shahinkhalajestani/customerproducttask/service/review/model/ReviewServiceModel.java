package com.shahinkhalajestani.customerproducttask.service.review.model;

import java.time.LocalDateTime;

import com.shahinkhalajestani.customerproducttask.model.reivew.Vote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewServiceModel {

	private String productId;

	private String customerId;

	private String comment;

	private Vote vote;

	private LocalDateTime reviewDate;

}
