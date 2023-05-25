package com.ssafy.edu.interceptor;


import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.edu.exception.ErrorCode;
import com.ssafy.edu.exception.TokenExpiredException;
import com.ssafy.edu.exception.TokenInvalidException;
import com.ssafy.edu.exception.UnAuthorizedException;
import com.ssafy.edu.member.service.JwtService;
import com.ssafy.edu.member.service.MemberService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.swagger.models.HttpMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtInterceptor implements HandlerInterceptor {
	
	private final JwtService jwtService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (isPreflightRequest(request)) {
			return true;
		}
		String token = request.getHeader("access-token");
		String refreshToken = request.getHeader("refresh-token");
		
		// 둘다 없음 : un_authorized
		if (token == null || refreshToken == null) {
			throw new UnAuthorizedException(ErrorCode.UN_AUTHORIZED);
		}
		//refreshToken 먼저 체크
		try {
			jwtService.checkToken(refreshToken);
		} catch(Exception e) {
			throw new TokenInvalidException(ErrorCode.TOKEN_INVALID);
		}
		
		try {
			jwtService.checkToken(token);
		} catch(MalformedJwtException | UnsupportedJwtException | SignatureException e) {
			throw new TokenInvalidException(ErrorCode.TOKEN_INVALID);
		} catch(ExpiredJwtException e) {
			//여기서 새로 accesstoken 발급해주기.
			String memberId = jwtService.getMemberId(refreshToken);
			String newToken = jwtService.createAccessToken("memberId", memberId);
			response.setHeader("Access-Control-Expose-Headers", "access-token");
			response.setHeader("access-token", newToken);
			throw new TokenExpiredException(ErrorCode.TOKEN_EXPIRED);
		}
		 
		
		return true;
	}


	private boolean isPreflightRequest(HttpServletRequest request) {
		return isOptions(request) && hasHeaders(request) && hasMethod(request) && hasOrigin(request);
	}

	private boolean hasOrigin(HttpServletRequest request) {
		return Objects.nonNull(request.getHeader("Origin"));
	}

	private boolean hasMethod(HttpServletRequest request) {
		return Objects.nonNull(request.getHeader("Access-Control-Request-Method"));
	}

	private boolean isOptions(HttpServletRequest request) {
		return request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.toString());
	}

	private boolean hasHeaders(HttpServletRequest request) {
		return Objects.nonNull(request.getHeader("Access-Control-Request-Headers"));
	}


}
