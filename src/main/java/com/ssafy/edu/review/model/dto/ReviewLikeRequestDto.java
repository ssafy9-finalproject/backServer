package com.ssafy.edu.review.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ReviewLikeRequestDto {

	private String member_id;
	private Long review_id;
}
