package com.ssafy.edu.member.controller;

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

import com.ssafy.edu.member.model.dto.MemberDto;
import com.ssafy.edu.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class JoinController {
	
	private final MemberService memberService;
	
	// 회원가입 : insert
	@PostMapping("/join")
	public ResponseEntity<?> join(@RequestBody MemberDto mdto) {
		memberService.join(mdto);
		MemberDto responsedto = memberService.memberDetail(mdto.getMemberId());
		if (responsedto != null) { // 성공
			return new ResponseEntity<MemberDto>(responsedto, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	// 중복 아이디 체크
	@GetMapping("/check/{memberId}")
	public ResponseEntity<?> duplicatedIdCheck(@PathVariable("memberId") String memberId){
		MemberDto responsedto = memberService.memberDetail(memberId);
		if (responsedto != null) { // 중복있음 : 반환 dto 있음
			return new ResponseEntity<MemberDto>(responsedto, HttpStatus.OK);
		}
		else { // 반환없음. 가입가능
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
}
