package com.ssafy.edu.util;

import lombok.Getter;
import lombok.Setter;

public class <T> MessageDto {
	private boolean success;
	
	
	
	public MessageDto(int message) {
		this.message = message;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}
}
