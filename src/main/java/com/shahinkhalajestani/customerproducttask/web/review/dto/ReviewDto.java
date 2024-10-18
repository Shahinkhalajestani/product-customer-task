package com.shahinkhalajestani.customerproducttask.web.review.dto;

import java.time.LocalDateTime;

import com.shahinkhalajestani.customerproducttask.model.reivew.Vote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

	private String productId;

	private String customerId;

	private String comment;

	private Vote vote;

	private LocalDateTime reviewDate;

}
