package com.ssafy.edu.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class JoinController {
	
	private final MemberService memberService;
	
	// 회원가입 : insert
	@PostMapping("/join")
	public ResponseEntity<?> join(@RequestBody MemberDto mdto) {
		try {
			memberService.join(mdto);
			// join후 유저정보 찾기
			MemberDto dto = memberService.memberDetail(mdto.getMemberId());
			// 잘 등록되면 : messagedto 반환
			MessageDto message = new MessageDto();
			if (dto != null) { // 성공
				message.setMessage(1);
				return new ResponseEntity<MessageDto>(message, HttpStatus.OK);
			}
			else { // 이거 프론트단에서 응답코드 처리해야하는지 아직 모르겠음.
				message.setMessage(0);
				return new ResponseEntity<MessageDto>(message, HttpStatus.NO_CONTENT);
			}
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	// 예외
	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
