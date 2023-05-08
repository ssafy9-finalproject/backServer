package com.ssafy.edu.plan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.edu.plan.model.dto.PlanAttractionResponseDto;
import com.ssafy.edu.plan.model.dto.PlanRegistRequestDto;

@Service
public interface PlanService {

	List<PlanAttractionResponseDto> keywordSearch(String keyword);

	void registPlan(PlanRegistRequestDto dto);

}
