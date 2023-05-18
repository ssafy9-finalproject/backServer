package com.ssafy.edu.review.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.review.model.dto.MyPlanResponseDto;
import com.ssafy.edu.review.model.dto.MyPlanReviewResponseDto;
import com.ssafy.edu.review.service.ReviewService;
import com.ssafy.edu.utils.ApiUtils;
import com.ssafy.edu.utils.ApiUtils.ApiResult;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class ReviewController {
	private final ReviewService reviewService;
	
	@GetMapping("/review/{id}")
	public ApiResult<List<MyPlanResponseDto>> planList(@PathVariable String id) {
		id = "admin";
		return ApiUtils.success(reviewService.planList(id));
	}
	@GetMapping("/review/myplan/{pid}")
	public ApiResult<MyPlanReviewResponseDto> myPlanReview(@PathVariable String pid) {
		return ApiUtils.success(reviewService.myPlanReview(pid));
	}
}
