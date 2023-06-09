package com.ssafy.edu.review.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class MyPlanResponseDto {

	private long plan_id;
	private String member_id;
	private String title;
	private LocalDate start_date;
	private LocalDate end_date;
	private String contents;
	private Integer isReviewExist;
	
}
