package com.ssafy.edu.review.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.review.model.dto.MyPlanResponseDto;
import com.ssafy.edu.review.model.dto.MyPlanReviewResponseDto;
import com.ssafy.edu.review.model.dto.ReviewLikeRequestDto;
import com.ssafy.edu.review.model.dto.ReviewListResponseDto;
import com.ssafy.edu.review.model.dto.ReviewRegistRequestDto;
import com.ssafy.edu.review.model.dto.SingleReviewResponseDto;
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
	
	@PostMapping("/review")
	public ApiResult<?> registReview(@RequestBody ReviewRegistRequestDto dto) {
		reviewService.registReview(dto);
		return ApiUtils.success(null);
	}
	
	@GetMapping("/review")
	public ApiResult<List<ReviewListResponseDto>> reviewList() {
		return ApiUtils.success(reviewService.reviewList());
	}
	
	@GetMapping("/review/all/{id}")
	public ApiResult<SingleReviewResponseDto> getReview(@PathVariable Long id) {
		return ApiUtils.success(reviewService.getReview(id));
	}
	@PutMapping("/review")
	public ApiResult<?> modifyReview(@RequestBody ReviewRegistRequestDto dto) {
		reviewService.modifyReview(dto);
		return ApiUtils.success(null);
	}
	@DeleteMapping("/review/all/{id}")
	public ApiResult<SingleReviewResponseDto> deleteReview(@PathVariable Long id) {
		reviewService.deleteReview(id);
		return ApiUtils.success(null);
	}
	@GetMapping("/review/hit/{id}")
	public ApiResult<?> updateHit(@PathVariable Long id) {
		reviewService.updateHit(id);
		return ApiUtils.success(null);
	}
	
	@PostMapping("/review/like") 
	public ApiResult<?> updateLike(@RequestBody ReviewLikeRequestDto dto) {
		reviewService.updateLike(dto);
		return ApiUtils.success(null);
	}
	@PutMapping("/review/like") 
	public ApiResult<?> deleteLike(@RequestBody ReviewLikeRequestDto dto) {
		reviewService.deleteLike(dto);
		return ApiUtils.success(null);
	} 
}
