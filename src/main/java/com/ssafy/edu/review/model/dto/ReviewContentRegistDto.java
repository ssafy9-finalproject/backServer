package com.ssafy.edu.review.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ReviewContentRegistDto {

	private Long review_id;
	private String contents;
	private LocalDate review_date;
}
