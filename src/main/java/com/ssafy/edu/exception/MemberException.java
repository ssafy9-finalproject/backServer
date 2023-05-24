package com.ssafy.edu.exception;

import lombok.Getter;

@Getter
public class MemberException extends RuntimeException {
	public MemberException(ErrorCode errorCode) {
		super(errorCode.getDescription());	
	}
}
