package com.ssafy.edu.review.model.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.edu.review.model.dto.MyPlanResponseDto;
import com.ssafy.edu.review.model.dto.MyPlanReviewResponseEntity;
import com.ssafy.edu.review.model.dto.ReviewCommentsRequestDto;
import com.ssafy.edu.review.model.dto.ReviewCommentsResponseDto;
import com.ssafy.edu.review.model.dto.ReviewContentRegistDto;
import com.ssafy.edu.review.model.dto.ReviewLikeRequestDto;
import com.ssafy.edu.review.model.dto.ReviewListResponseDto;
import com.ssafy.edu.review.model.dto.ReviewMapperRequestDto;
import com.ssafy.edu.review.model.dto.ReviewModifyModel;
import com.ssafy.edu.review.model.dto.ReviewRegistRequestDto;
import com.ssafy.edu.review.model.dto.SingleReviewMapperDto;

@Mapper
public interface ReviewMapper {

	List<MyPlanResponseDto> planList(String id);

	List<MyPlanReviewResponseEntity> myPlanReview(String pid);

	void registReview(ReviewRegistRequestDto dto);

	void registReviewContent(ReviewContentRegistDto rDto);

	List<ReviewListResponseDto> reviewList();

	List<SingleReviewMapperDto> getReview(ReviewMapperRequestDto dto);

	void deleteReview(Long id);

	void modifyReview(ReviewRegistRequestDto dto);

	void modifyReviewContents(ReviewModifyModel rModel);

	void updateHit(Long id);

	void updateLike(ReviewLikeRequestDto dto);

	void deleteLike(ReviewLikeRequestDto dto);

	List<ReviewCommentsResponseDto> getComments(Long id);

	void registComments(ReviewCommentsRequestDto dto);


}
