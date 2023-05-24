package com.ssafy.edu.exception;

import lombok.Getter;

@Getter
public class TokenInvalidException extends RuntimeException {
	private static final long serialVersionUID = -2238030302650813813L;
	
	private final ErrorCode errorCode;
	private final String errorMessage;
		
	public TokenInvalidException(ErrorCode errorCode) {
		this.errorCode = errorCode;
		this.errorMessage = errorCode.getDescription();
	}
}
