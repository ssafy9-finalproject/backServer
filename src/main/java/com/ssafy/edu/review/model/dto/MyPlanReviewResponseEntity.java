package com.ssafy.edu.review.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyPlanReviewResponseEntity {

	private long plan_id;
	private String member_id;
	private String title;
	private LocalDate start_date;
	private LocalDate end_date;
	private String contents;
	private long content_id;
	private LocalDate plan_date;
	private String attraction_title;
	private int content_type_id;
}
