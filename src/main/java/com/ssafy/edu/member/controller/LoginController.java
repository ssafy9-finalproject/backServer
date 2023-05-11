package com.ssafy.edu.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.edu.member.model.dto.MemberDto;
import com.ssafy.edu.member.service.MemberService;

@Controller
@CrossOrigin("*")
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private MemberService memberService;
 
	public LoginController(MemberService memberService) 
	{
		this.memberService = memberService; 
	}
	
	// 로그인
	@PostMapping("/login")
	@ResponseBody
	public MemberDto login(@RequestBody MemberDto mdto) throws Exception {
		return memberService.login(mdto);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
