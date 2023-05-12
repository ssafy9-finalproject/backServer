package com.ssafy.edu.review.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class MyPlanReviewResponseDto {
	private long plan_id;
	private String member_id;
	private String title;
	private LocalDate start_date;
	private LocalDate end_date;
	private String contents;
	private List<List<ReviewDate>> list;
	public MyPlanReviewResponseDto(long plan_id, String member_id, String title, LocalDate start_date,
			LocalDate end_date, String contents) {
		super();
		this.plan_id = plan_id;
		this.member_id = member_id;
		this.title = title;
		this.start_date = start_date;
		this.end_date = end_date;
		this.contents = contents;
		list = new ArrayList<List<ReviewDate>>();
	}
}
