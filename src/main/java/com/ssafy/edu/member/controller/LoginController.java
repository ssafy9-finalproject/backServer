package com.ssafy.edu.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.exception.NotFoundException;
import com.ssafy.edu.member.model.dto.MemberDto;
import com.ssafy.edu.member.service.JwtServiceImpl;
import com.ssafy.edu.member.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@Api("사용자 컨트롤러  API V1")
public class LoginController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private final JwtServiceImpl jwtService;
	
	private final MemberService memberService;
	
	// 로그인
	@ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDto mdto){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		MemberDto loginUser = memberService.login(mdto);
		if (loginUser != null) { // 유저정보가 있음.
			String accessToken = jwtService.createAccessToken("memberId", loginUser.getMemberId());// key, data
			String refreshToken = jwtService.createRefreshToken("memberId", loginUser.getMemberId());// key, data
			memberService.saveRefreshToken(mdto.getMemberId(), refreshToken);
			resultMap.put("access-token", accessToken);
			resultMap.put("refresh-token", refreshToken);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		}
		else { // 해당 유저가 없음.
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/info/{memberId}")
	public ResponseEntity<Map<String, Object>> getInfo(@PathVariable("memberId") String memberId,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			MemberDto memberDto = memberService.memberDetail(memberId);
			resultMap.put("userInfo", memberDto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} else {
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	// 로그아웃
	@GetMapping("/logout/{memberId}")
	public ResponseEntity<?> removeToken(@PathVariable("memberId") String memberId){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		memberService.deleRefreshToken(memberId);
		resultMap.put("message", SUCCESS);
		status = HttpStatus.ACCEPTED;
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	
	// 토큰 갱신
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody MemberDto memberDto, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		if (jwtService.checkToken(token)) {
			if (token.equals(memberService.getRefreshToken(memberDto.getMemberId()))) {
				String accessToken = jwtService.createAccessToken("memberId", memberDto.getMemberId());
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
}
