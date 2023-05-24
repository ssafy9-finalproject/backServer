package com.ssafy.edu.exception;

import lombok.Getter;

@Getter
public class TokenExpiredException extends RuntimeException {
	private static final long serialVersionUID = -2238030302650813813L;
	
	public TokenExpiredException(ErrorCode errorCode) {
		super(errorCode.getDescription());
	}
}
