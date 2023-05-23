package com.ssafy.edu.review.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class ReviewCommentsRequestDto {
	private String member_id;
	private String review_id;
	private String contents;
	public ReviewCommentsRequestDto(String member_id, String review_id, String contents) {
		super();
		this.member_id = member_id;
		this.review_id = review_id;
		this.contents = contents;
	}
}
