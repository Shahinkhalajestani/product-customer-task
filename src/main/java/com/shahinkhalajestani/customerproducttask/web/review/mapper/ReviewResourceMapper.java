package com.shahinkhalajestani.customerproducttask.web.review.mapper;

import java.util.List;

import com.shahinkhalajestani.customerproducttask.base.model.ResultStatus;
import com.shahinkhalajestani.customerproducttask.service.review.model.ReviewServiceModel;
import com.shahinkhalajestani.customerproducttask.web.review.dto.ReviewDto;
import com.shahinkhalajestani.customerproducttask.web.review.dto.ReviewResponseModel;
import com.shahinkhalajestani.customerproducttask.web.review.dto.ReviewSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, imports = { ResultStatus.class })
public interface ReviewResourceMapper {

	ReviewDto toReviewDto(ReviewServiceModel reviewServiceModel);

	@Named("toReviewDtos")
	List<ReviewDto> toReviewDtos(List<ReviewServiceModel> reviewServiceModels);


	default ReviewResponseModel tReviewResponseModel(List<ReviewServiceModel> reviews) {
		ReviewResponseModel reviewResponseModel = new ReviewResponseModel();
		reviewResponseModel.setResultStatus(ResultStatus.SUCCESS);
		reviewResponseModel.setReviews(toReviewDtos(reviews));
		return reviewResponseModel;
	}

	@Mapping(target = "reviewDate", ignore = true)
	ReviewServiceModel toReviewServiceModel(ReviewSaveRequest reviewSaveRequest);

}
