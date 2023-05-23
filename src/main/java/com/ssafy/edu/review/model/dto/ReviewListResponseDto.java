package com.ssafy.edu.review.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ReviewListResponseDto {

	private Long review_id;
	private String title;
	private LocalDate start_date;
	private LocalDate end_date;
}
