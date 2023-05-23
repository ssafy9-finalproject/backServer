package com.ssafy.edu.review.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class ReviewMapperRequestDto {

	private Long id;
	private String memberId;
	public ReviewMapperRequestDto(Long id, String memberId) {
		this.id = id;
		this.memberId = memberId;
	}
}
