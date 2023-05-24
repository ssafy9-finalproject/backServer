package com.ssafy.edu.review.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @Getter @Setter
@ToString
public class ReviewCommentsResponseDto {

	private Long comment_id;
	private String member_id;
	private String contents;
	public ReviewCommentsResponseDto(Long comment_id, String member_id, String contents) {
		super();
		this.comment_id = comment_id;
		this.member_id = member_id;
		this.contents = contents;
	}
	
}
