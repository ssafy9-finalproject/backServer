package com.ssafy.edu.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	INTERNAL_SERVER_ERROR("내부 서버 오류입니다."),
	MEMBER_NOT_FOUND("회원을 찾을 수 없습니다."),
	TOKEN_INVALID("토큰이 유효하지 않습니다."),
	TOKEN_EXPIRED("토큰 유효기간이 만료되었습니다."),
	UN_AUTHORIZED("로그인이 필요 합니다.");
	private final String description;
}
