package com.ssafy.edu.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.edu.member.model.dto.MemberDto;
import com.ssafy.edu.member.service.MemberService;

@Controller
@CrossOrigin("*")
public class JoinController {
	private final Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	private MemberService memberService;
 
	public JoinController(MemberService memberService) 
	{
		this.memberService = memberService; 
	}
	
	// 회원가입
	@PostMapping("/join")
	@ResponseBody
	public void join(@RequestBody MemberDto mdto) throws Exception {
		memberService.join(mdto);
	}
}
