package com.shahinkhalajestani.customerproducttask.service.review.Impl;

import java.util.Collections;
import java.util.List;

import com.shahinkhalajestani.customerproducttask.model.product.ProductReviewVisibility;
import com.shahinkhalajestani.customerproducttask.model.reivew.dao.ReviewDao;
import com.shahinkhalajestani.customerproducttask.service.customer.CustomerService;
import com.shahinkhalajestani.customerproducttask.service.order.OrderService;
import com.shahinkhalajestani.customerproducttask.service.product.ProductService;
import com.shahinkhalajestani.customerproducttask.service.product.model.ProductServiceModel;
import com.shahinkhalajestani.customerproducttask.service.review.ReviewService;
import com.shahinkhalajestani.customerproducttask.service.review.mapper.ReviewServiceMapper;
import com.shahinkhalajestani.customerproducttask.service.review.model.ReviewServiceModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	private final ReviewDao reviewDao;

	private final CustomerService customerService;

	private final ProductService productService;

	private final ReviewServiceMapper serviceMapper;

	private final OrderService orderService;


	@Override
	public List<ReviewServiceModel> getProductReviews(String productId, String customerId) {
		var product = productService.getProduct(productId);
		var customer = customerService.getCustomer(customerId);
		if (ProductReviewVisibility.EVERY_ONE.equals(product.getReviewVisibility())) {
			var reviews = reviewDao.findAllByProductId(product.getProductId());
			return serviceMapper.toReviewModels(reviews);
		} else if (isReviewsVisibleJustForBuyers(productId, customerId, product)) {
			log.info("Going to fetch reviews for buying customers for product : {}, and customer : {}"
					,product.getProductId(), customer.getNationalCode());
			var reviews = reviewDao.findAllByProductId(product.getProductId());
			return serviceMapper.toReviewModels(reviews);
		}else {
			return Collections.emptyList();
		}
	}

	private boolean isReviewsVisibleJustForBuyers(String productId, String customerId, ProductServiceModel product) {
		return ProductReviewVisibility.BUYERS.equals(product.getReviewVisibility()) && orderService.doesOrderExists(productId, customerId);
	}

	@Override
	@Transactional
	public void addReview(ReviewServiceModel reviewServiceModel) {
		var customer = customerService.getCustomer(reviewServiceModel.getCustomerId());
		var product = productService.getProduct(reviewServiceModel.getProductId());
		log.info("Going to add review for product : {} and customer : {}", product.getProductId(), customer.getNationalCode());
		var review  = serviceMapper.toReview(reviewServiceModel);
		reviewDao.save(review);
	}
}
