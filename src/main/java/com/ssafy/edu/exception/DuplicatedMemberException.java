package com.ssafy.edu.exception;

import lombok.Getter;

@Getter
public class DuplicatedMemberException extends RuntimeException{
	public DuplicatedMemberException(ErrorCode errorCode) {
		super(errorCode.getDescription());
	}
}
