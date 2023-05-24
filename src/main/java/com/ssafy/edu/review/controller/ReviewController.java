package com.ssafy.edu.review.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.exception.NotFoundException;
import com.ssafy.edu.member.service.JwtService;
import com.ssafy.edu.review.model.dto.MyPlanResponseDto;
import com.ssafy.edu.review.model.dto.MyPlanReviewResponseDto;
import com.ssafy.edu.review.model.dto.ReviewCommentsRequestDto;
import com.ssafy.edu.review.model.dto.ReviewCommentsResponseDto;
import com.ssafy.edu.review.model.dto.ReviewLikeRequestDto;
import com.ssafy.edu.review.model.dto.ReviewListResponseDto;
import com.ssafy.edu.review.model.dto.ReviewRegistRequestDto;
import com.ssafy.edu.review.model.dto.SingleReviewResponseDto;
import com.ssafy.edu.review.service.ReviewService;
import com.ssafy.edu.utils.ApiUtils;
import com.ssafy.edu.utils.ApiUtils.ApiResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class ReviewController {
	private final ReviewService reviewService;
	private final JwtService jwtService;
	
	@GetMapping("/review/myplan")
	public ApiResult<List<MyPlanResponseDto>> planList(HttpServletRequest request) {
		String token = request.getHeader("access-token");
		String id = jwtService.getMemberId(token);
		return ApiUtils.success(reviewService.planList(id));
	}
	@GetMapping("/review/myplan/{pid}")
	public ApiResult<MyPlanReviewResponseDto> myPlanReview(@PathVariable String pid) {
		return ApiUtils.success(reviewService.myPlanReview(pid));
	}
	
	@PostMapping("/review")
	public ApiResult<?> registReview(@Validated @RequestBody ReviewRegistRequestDto dto) {
		reviewService.registReview(dto);
		return ApiUtils.success(null);
	}
	
	@GetMapping("/review")
	public ApiResult<List<ReviewListResponseDto>> reviewList() {
		return ApiUtils.success(reviewService.reviewList());
	}
	
	@GetMapping("/review/all/{id}")
	public ApiResult<SingleReviewResponseDto> getReview(@PathVariable Long id, HttpServletRequest request) {
		String token = request.getHeader("access-token");
		if(token == null) {
			return ApiUtils.success(reviewService.getReview(id,""));
		}
		String memberId = jwtService.getMemberId(token);
		return ApiUtils.success(reviewService.getReview(id,memberId));
	}
	@PutMapping("/review")
	public ApiResult<?> modifyReview(@Validated @RequestBody ReviewRegistRequestDto dto) {
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
	@GetMapping("/review/comments/{id}")
	public ApiResult<List<ReviewCommentsResponseDto>> getComments(@PathVariable Long id) {
		return ApiUtils.success(reviewService.getComments(id));
	}
	@PostMapping("/review/comments")
	public ApiResult<?> reigstComments(@RequestBody ReviewCommentsRequestDto dto) {
		reviewService.registComments(dto);
		return ApiUtils.success(null);
	}
	@DeleteMapping("/review/comments/{id}")
	public ApiResult<?> deleteComments(@PathVariable Long id) {
		reviewService.deleteComments(id);
		return ApiUtils.success(null);
	}
}
