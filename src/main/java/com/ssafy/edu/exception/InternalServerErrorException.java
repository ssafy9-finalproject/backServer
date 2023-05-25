package com.ssafy.edu.exception;

import lombok.Getter;

@Getter
public class InternalServerErrorException extends RuntimeException {
	public InternalServerErrorException(ErrorCode errorCode) {
		super(errorCode.getDescription());
	}
}
