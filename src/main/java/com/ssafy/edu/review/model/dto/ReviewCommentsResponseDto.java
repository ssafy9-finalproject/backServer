package com.ssafy.edu.review.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class ReviewCommentsResponseDto {

	private String member_id;
	private String contents;
	public ReviewCommentsResponseDto(String member_id, String contents) {
		this.member_id = member_id;
		this.contents = contents;
	}
}
