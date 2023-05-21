package com.ssafy.edu.review.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class SingleReviewMapperDto {

	private String title;
	private Integer hit;
	private String member_id;
	private LocalDate start_date;
	private LocalDate end_date;
	private LocalDate review_date;
	private String contents;
	private Integer content_type_id;
	private String attractionName;
	private Integer isLikeExist;
	private Integer likeCount;
}
