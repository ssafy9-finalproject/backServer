package com.ssafy.edu.exception;

import lombok.Getter;

@Getter
public class UnAuthorizedException extends RuntimeException {
	private static final long serialVersionUID = -2238030302650813813L;
	
	public UnAuthorizedException(ErrorCode errorCode) {
		super(errorCode.getDescription());
	}
}
