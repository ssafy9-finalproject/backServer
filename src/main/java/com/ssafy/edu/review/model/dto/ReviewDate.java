package com.ssafy.edu.review.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class ReviewDate {

	private long content_id;
	private LocalDate plan_date;
	private String attraction_title;
	private int content_type_id;
}
