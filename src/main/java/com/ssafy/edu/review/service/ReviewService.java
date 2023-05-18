package com.ssafy.edu.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.edu.review.model.dto.MyPlanResponseDto;
import com.ssafy.edu.review.model.dto.MyPlanReviewResponseDto;
import com.ssafy.edu.review.model.dto.ReviewListResponseDto;
import com.ssafy.edu.review.model.dto.ReviewRegistRequestDto;
import com.ssafy.edu.review.model.dto.SingleReviewResponseDto;

@Service
public interface ReviewService {

	List<MyPlanResponseDto> planList(String id);

	MyPlanReviewResponseDto myPlanReview(String pid);

	void registReview(ReviewRegistRequestDto dto);

	List<ReviewListResponseDto> reviewList();

	List<SingleReviewResponseDto> getReview(Long id);

}
