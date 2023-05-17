package com.ssafy.edu.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.member.model.dto.MemberDto;
import com.ssafy.edu.member.service.MemberService;
import com.ssafy.edu.util.MessageDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginController {
	
	private final MemberService memberService;
	
	// 로그인
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody MemberDto mdto){
		try {
			MemberDto dto = memberService.login(mdto);
			MessageDto message = new MessageDto();
			if (dto != null) { // 유저정보가 있음.
				return new ResponseEntity<MemberDto>(dto, HttpStatus.OK);
			}
			else {
				message.setMessage(0);
				return new ResponseEntity<MessageDto>(message, HttpStatus.NO_CONTENT);
			}
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}
	
}
