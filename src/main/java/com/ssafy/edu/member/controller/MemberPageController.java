package com.ssafy.edu.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.edu.member.model.dto.MemberDto;
import com.ssafy.edu.member.service.MemberService;

//json 안던져줌.
@Controller
@RequestMapping(value = "/member")
public class MemberPageController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);

	private MemberService memberService;
	
	
	public MemberPageController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	// 회원가입
	@PostMapping("/join")
	public String join(MemberDto mdto) throws Exception {
		memberService.join(mdto);
		return "redirect:/";
	}
	
	// 로그인
	@PostMapping("/login")
	public String login(MemberDto mdto, HttpSession session) throws Exception {
		logger.debug("write login : {}", mdto);
		MemberDto login = memberService.login(mdto);
		if (login != null) { // 로그인 성공시
			session.setAttribute("login", login);
		}
		else {
			session.invalidate();
		}
		return "redirect:/";
	}

	@GetMapping("/join")
	public String join() {
		return "member/registry";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 세부정보 화면전환
	@GetMapping("/memberdetail/{memberId}")
	public String memberdetail2(@PathVariable String memberId) {
		return "member/memberdetail";
	}
	
	@GetMapping("/memberlistmf")
	public String memberlist() throws Exception {
		logger.debug("memberModify memberlist : {}");
		return "member/memberlist";
	} 
	
	// 업데이트 창 이동
	@GetMapping("/memberupdate/{memberId}")
	public String memberupdate(@PathVariable("memberId") String memberId) throws Exception {
		return "member/memberupdate";
	}
	
	
	// 비밀번호 찾기 창 이동
	@GetMapping("/findById")
	public String findByPassword() {
		return "member/password";
	}
	
//	@GetMapping("/password/{memberId}")
//	public String password(@PathVariable String memberId) throws Exception {
//		return "member/password2";
//	}
}
