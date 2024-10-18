package com.shahinkhalajestani.customerproducttask.service.review;

import java.util.List;

import com.shahinkhalajestani.customerproducttask.service.review.model.ReviewServiceModel;

public interface ReviewService {


	List<ReviewServiceModel> getProductReviews(String productId, String customerId);


	void addReview(ReviewServiceModel reviewServiceModel);

}
