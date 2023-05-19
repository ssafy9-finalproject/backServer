package com.ssafy.edu.review.model.dto;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class SingleReviewResponseDto {
	private String title;
	private Integer hit;
	private List<SingleReviewDailyModel> dailyList;
}
