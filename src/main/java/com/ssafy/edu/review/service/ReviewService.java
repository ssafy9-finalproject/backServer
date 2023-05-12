package com.ssafy.edu.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.edu.review.model.dto.MyPlanResponseDto;

@Service
public interface ReviewService {

	List<MyPlanResponseDto> planList(String id);

}
