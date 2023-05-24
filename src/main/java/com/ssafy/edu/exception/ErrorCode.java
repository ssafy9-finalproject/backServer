package com.ssafy.edu.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	TOKEN_INVALID("토큰이 유효하지 않습니다."),
	TOKEN_EXPIRED("토큰 유효기간이 만료되었습니다."),
	UN_AUTHORIZED("로그인이 필요 합니다.");
	private final String description;
}
