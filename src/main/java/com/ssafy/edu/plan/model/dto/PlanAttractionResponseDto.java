package com.ssafy.edu.plan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PlanAttractionResponseDto {

	private long content_id;
	private int content_type_id;
	private String title;
	private String addr1;
	private String first_image2;
	private int sido_code;
	private int gugun_code;
	private double latitude;
	private double longitude;
	public PlanAttractionResponseDto() {
	}
	public PlanAttractionResponseDto(long content_id, int content_type_id, String title, String addr1,
			String first_image2, int sido_code, int gugun_code, double latitude, double longitude) {
		super();
		this.content_id = content_id;
		this.content_type_id = content_type_id;
		this.title = title;
		this.addr1 = addr1;
		this.first_image2 = first_image2;
		this.sido_code = sido_code;
		this.gugun_code = gugun_code;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
}
