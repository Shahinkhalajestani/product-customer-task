package com.shahinkhalajestani.customerproducttask.web.review;

import com.shahinkhalajestani.customerproducttask.base.model.ResponseModel;
import com.shahinkhalajestani.customerproducttask.service.review.ReviewService;
import com.shahinkhalajestani.customerproducttask.web.review.dto.ReviewResponseModel;
import com.shahinkhalajestani.customerproducttask.web.review.dto.ReviewSaveRequest;
import com.shahinkhalajestani.customerproducttask.web.review.mapper.ReviewResourceMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewResource {

	private final ReviewService reviewService;

	private final ReviewResourceMapper resourceMapper;


	@PostMapping
	public ResponseEntity<ResponseModel> saveReview(@RequestBody @Valid ReviewSaveRequest reviewSaveRequest) {
		log.info("Going to save review for product : {}", reviewSaveRequest.getProductId());
		var serviceModel = resourceMapper.toReviewServiceModel(reviewSaveRequest);
		reviewService.addReview(serviceModel);
		return ResponseEntity.ok(ResponseModel.success());
	}



	@GetMapping()
	public ResponseEntity<ReviewResponseModel> getReview(@RequestParam(name = "productId") String productId,
			@RequestParam(name = "customerId") String customerId) {
		log.info("Going to get review for product : {}", productId);
		var reviews = reviewService.getProductReviews(productId, customerId);
		return ResponseEntity.ok(resourceMapper.tReviewResponseModel(reviews));
	}

}
