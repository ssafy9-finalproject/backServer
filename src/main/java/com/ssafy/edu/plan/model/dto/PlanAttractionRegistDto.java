package com.ssafy.edu.plan.model.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlanAttractionRegistDto {

	private long plan_id;
	private List<Integer> list;
	private LocalDate plan_date;
	public PlanAttractionRegistDto() {
	}
	public PlanAttractionRegistDto(long plan_id, List<Integer> list, LocalDate plan_date) {
		super();
		this.plan_id = plan_id;
		this.list = list;
		this.plan_date = plan_date;
	}

}
