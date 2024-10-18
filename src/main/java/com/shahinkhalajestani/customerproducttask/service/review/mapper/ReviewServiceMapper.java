package com.shahinkhalajestani.customerproducttask.service.review.mapper;

import java.time.LocalDateTime;
import java.util.List;

import com.shahinkhalajestani.customerproducttask.model.reivew.Review;
import com.shahinkhalajestani.customerproducttask.service.review.ReviewService;
import com.shahinkhalajestani.customerproducttask.service.review.model.ReviewServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, imports = { LocalDateTime.class })
public interface ReviewServiceMapper {


	@Mapping(target = "id", ignore = true)
	@Mapping(target = "reviewDate", expression = "java(LocalDateTime.now())")
	Review toReview(ReviewServiceModel reviewServiceModel);


	ReviewServiceModel toReviewModel(Review review);


	List<ReviewServiceModel> toReviewModels(List<Review> reviews);


}
