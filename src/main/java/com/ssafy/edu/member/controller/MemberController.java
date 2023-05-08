package com.ssafy.edu.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.member.model.dto.MemberDto;
import com.ssafy.edu.member.service.MemberService;

@Controller
@RequestMapping(value="/member")
@CrossOrigin("*")
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberService;
 
	public MemberController(MemberService memberService) 
	{
		this.memberService = memberService; 
	}
		
	 
	@GetMapping("/memberlist")
	@ResponseBody
	public List<MemberDto> memberlist() throws Exception {
		return memberService.memberlist();
	}
	
	//
	@GetMapping("/memberdetailmf/{memberId}")
	@ResponseBody
	public MemberDto memberdetail(@PathVariable("memberId") String memberId) throws Exception {
		return memberService.memberDetail(memberId);	
	}
	
	
	
	@PostMapping("/memberupdateaf")
	public String memberUpdateaf(@RequestBody MemberDto memberDto) throws Exception {
		logger.debug("memberModify memberDto : {}", memberDto);
		memberService.memberUpdate(memberDto);
		return "redirect:/member/memberlistmf";
	}
	
	
	
	// 삭제 api
	@PostMapping("/memberDelete/{memberId}")
	public String memberDelete(@PathVariable("memberId") String memberId) throws Exception {
		logger.debug("userDelete userid : {}", memberId);
		memberService.memberDelete(memberId);
		return "redirect:/member/memberlistmf";
	}
		

	// 비번찾기
	@GetMapping("/password/{memberId}")
	public String findById(@PathVariable("memberId") String memberId) throws Exception {
		return memberService.findById(memberId); // message.jsp 대신에 어디로 표시?
	}

	// 예외
	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
