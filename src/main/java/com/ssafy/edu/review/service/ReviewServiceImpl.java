package com.ssafy.edu.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.edu.review.model.dao.ReviewMapper;
import com.ssafy.edu.review.model.dto.MyPlanResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

	private final ReviewMapper reviewMapper;

	@Override
	public List<MyPlanResponseDto> planList(String id) {
		return reviewMapper.planList(id);
	}
}
