package com.ssafy.edu.plan.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.edu.plan.model.dto.PlanAttractionRegistDto;
import com.ssafy.edu.plan.model.dto.PlanAttractionResponseDto;
import com.ssafy.edu.plan.model.dto.PlanRegistRequestDto;

@Mapper
public interface PlanMapper {

	List<PlanAttractionResponseDto> keywordSearch(String keyword);

	void registPlan(PlanRegistRequestDto dto);

	void registPlanAttraction(PlanAttractionRegistDto pDto);

}
