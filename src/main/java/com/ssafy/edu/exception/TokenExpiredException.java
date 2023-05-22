package com.ssafy.edu.exception;

public class TokenExpiredException extends RuntimeException {
	private static final long serialVersionUID = -2238030302650813813L;
	
	public TokenExpiredException() {
		super("토큰이 만료되었습니다.\n다시 로그인을 해주세요.");
	}
}
