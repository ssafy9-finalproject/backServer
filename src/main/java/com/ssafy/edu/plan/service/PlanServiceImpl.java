package com.ssafy.edu.plan.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.edu.plan.model.dao.PlanMapper;
import com.ssafy.edu.plan.model.dto.PlanAttractionRegistDto;
import com.ssafy.edu.plan.model.dto.PlanAttractionResponseDto;
import com.ssafy.edu.plan.model.dto.PlanRegistRequestDto;

@Service
public class PlanServiceImpl implements PlanService{
	
	PlanMapper planMapper;
	
	public PlanServiceImpl(PlanMapper planMapper) {
		this.planMapper = planMapper;
	}

	@Override
	public List<PlanAttractionResponseDto> keywordSearch(String keyword) {
		return planMapper.keywordSearch(keyword);
	}

	@Override
	public void registPlan(PlanRegistRequestDto dto) {
		planMapper.registPlan(dto);
		LocalDate startDate = dto.getStart_date();
		
		for(int i = 0; i < dto.getList().size(); i++) {
			PlanAttractionRegistDto pDto = new PlanAttractionRegistDto(dto.getPlan_id(), dto.getList().get(i), startDate);
			planMapper.registPlanAttraction(pDto);
			startDate = startDate.plusDays(1);
		}
	}

}
