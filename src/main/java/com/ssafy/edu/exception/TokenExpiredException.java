package com.ssafy.edu.exception;

import lombok.Getter;

@Getter
public class TokenExpiredException extends RuntimeException {
	private static final long serialVersionUID = -2238030302650813813L;
	
	private final ErrorCode errorCode;
	private final String errorMessage;
		
	public TokenExpiredException(ErrorCode errorCode) {
		this.errorCode = errorCode;
		this.errorMessage = errorCode.getDescription();
	}
}
