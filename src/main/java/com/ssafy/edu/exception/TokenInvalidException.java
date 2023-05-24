package com.ssafy.edu.exception;

import lombok.Getter;

@Getter
public class TokenInvalidException extends RuntimeException {
	private static final long serialVersionUID = -2238030302650813813L;
	
	public TokenInvalidException(ErrorCode errorCode) {
		super(errorCode.getDescription());
	}
}
