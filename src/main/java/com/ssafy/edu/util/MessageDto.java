package com.ssafy.edu.util;

import lombok.Getter;
import lombok.Setter;

public class MessageDto {
	private int message;
	
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
