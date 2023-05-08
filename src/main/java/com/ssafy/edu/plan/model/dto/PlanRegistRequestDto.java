package com.ssafy.edu.plan.model.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlanRegistRequestDto {

	private long plan_id;
	private String member_id;
	private String title;
	private LocalDate start_date;
	private LocalDate end_date;
	private String contents;
	private List<List<Integer>> list;
	
	public PlanRegistRequestDto() {
	}

	public PlanRegistRequestDto(long plan_id, String member_id, String title, LocalDate start_date, LocalDate end_date,
			String contents, List<List<Integer>> list) {
		super();
		this.plan_id = plan_id;
		this.member_id = member_id;
		this.title = title;
		this.start_date = start_date;
		this.end_date = end_date;
		this.contents = contents;
		this.list = list;
	}
}
