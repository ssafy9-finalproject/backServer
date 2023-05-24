package com.ssafy.edu.interceptor;


import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.edu.exception.TokenExpiredException;
import com.ssafy.edu.exception.UnAuthorizedException;
import com.ssafy.edu.member.service.JwtService;
import com.ssafy.edu.member.service.MemberService;

import io.swagger.models.HttpMethod;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtInterceptor implements HandlerInterceptor {
	
	//private final JwtService jwtService;
	private final MemberService memberService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		if (isPreflightRequest(request)) {
//			return true;
//		}
//		String token = request.getHeader("access-token");
//		String refreshToken = request.getHeader("refresh-token");
//		//log.debug("엑세스토큰 있음:{}",token);
//		//log.debug("리프레시토큰 있음:{}",refreshToken);
//		//log.debug("memberId 끌어올수있음:{}", jwtService.getMemberId(token));
//		
//		if (token == null && refreshToken == null) {
//			throw new UnAuthorizedException();
//		}
//		if (jwtService.checkToken(token)) {
//			return true;
//		} 
//		else if (jwtService.checkToken(refreshToken)) {
//			// 토큰이 존재하지않음
//			jwtService.createAccessToken("memberId", jwtService.getMemberId(refreshToken));
//			if (jwtService.checkToken(request.getHeader("access-token"))) {
//				return true;
//			}
//		}
//		throw new TokenExpiredException();
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
