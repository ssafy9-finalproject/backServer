package com.ssafy.edu.member.service;

import java.util.Map;

public interface JwtService {

	<T> String createAccessToken(String key, T data);
	<T> String createRefreshToken(String key, T data);
	<T> String create(String key, T data, String subject, long expir);
	boolean checkToken(String jwt);
	String getMemberId(String accessToken);
}
