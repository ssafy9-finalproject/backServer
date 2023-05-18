package com.ssafy.edu.review.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.edu.review.model.dto.MyPlanResponseDto;
import com.ssafy.edu.review.model.dto.MyPlanReviewResponseEntity;
import com.ssafy.edu.review.model.dto.ReviewContentRegistDto;
import com.ssafy.edu.review.model.dto.ReviewListResponseDto;
import com.ssafy.edu.review.model.dto.ReviewRegistRequestDto;
import com.ssafy.edu.review.model.dto.SingleReviewResponseDto;

@Mapper
public interface ReviewMapper {

	List<MyPlanResponseDto> planList(String id);

	List<MyPlanReviewResponseEntity> myPlanReview(String pid);

	void registReview(ReviewRegistRequestDto dto);

	void registReviewContent(ReviewContentRegistDto rDto);

	List<ReviewListResponseDto> reviewList();

	List<SingleReviewResponseDto> getReview(Long id);

}
