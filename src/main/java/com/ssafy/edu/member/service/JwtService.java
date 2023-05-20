package com.ssafy.edu.member.service;

import java.util.Map;

public interface JwtService {

	<T> String createAccessToken(String key, T data);
	<T> String createRefreshToken(String key, T data);
	<T> String create(String key, T data, String subject, long expir);
	String getMemberId(String accessToken);
//	Map<String, Object> get(String key);
//	String getUserId();
//	String decode(String accessToken);
	boolean checkToken(String jwt);
	
}
