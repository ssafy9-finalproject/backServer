package com.ssafy.edu.plan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.plan.model.dto.PlanAttractionResponseDto;
import com.ssafy.edu.plan.model.dto.PlanRegistRequestDto;
import com.ssafy.edu.plan.service.PlanService;

@RestController
@CrossOrigin("*")
public class PlanController {
	
	private PlanService planService;
	
	public PlanController(PlanService planService) {
		this.planService = planService;
	}

	@GetMapping("/plan/{keyword}")
	public List<PlanAttractionResponseDto> keywordSearch(@PathVariable String keyword) {
		return planService.keywordSearch(keyword);
	}
	
	@PostMapping("/plan")
	public String registPlan(@RequestBody PlanRegistRequestDto dto) {
		dto.setMember_id("admin");
		planService.registPlan(dto);
		return "testFin";
	}

}
