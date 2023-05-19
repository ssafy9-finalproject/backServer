package com.ssafy.edu.review.model.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class SingleReviewDailyModel {

	private LocalDate reviewDate;
	private String contents;
	private List<String> attractionName;
	private List<Integer> contentType;
}
