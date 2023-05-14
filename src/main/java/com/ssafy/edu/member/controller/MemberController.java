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
import com.ssafy.edu.util.MessageDto;
<<<<<<< HEAD
=======

import lombok.RequiredArgsConstructor;
>>>>>>> 44e5854354cca62055ea79df4e6cd0aec5ddee3c

// 화면이동 컨트롤러. 차근차근 없애기
@RestController
@RequiredArgsConstructor // MemberService를 한번 생성하고 바꿀필요없으므로 final, RequiredArgsConstructor사용
@CrossOrigin("*")
public class MemberController {
	
	private final MemberService memberService;
	
	// 응답 데이터: ResponseEntity로 전환
	// 회원 리스트 조회 : 리스트 반환
	@GetMapping("/memberlist")
	public ResponseEntity<?> memberlist() {
		try {
			List<MemberDto> list = memberService.memberlist();
			// 멤버리스트는 원소가 아무것도없어도 호출이 되어야한다.
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	// 회원 상세 : dto 반환
	@GetMapping("/memberdetail/{memberId}")
	public ResponseEntity<?> memberdetail(@PathVariable("memberId") String memberId){
		try {
			MemberDto dto = memberService.memberDetail(memberId);
			// 해당 사용자가 있어야함 : 상세 정보 전송
			if (dto != null) {
				return new ResponseEntity<MemberDto>(dto, HttpStatus.OK); 
			}
			else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}	
	}
	
	
	// 회원 수정 : messageDto 반환
	@PutMapping("/memberupdate")
	public ResponseEntity<?> memberupdate(@RequestBody MemberDto memberDto){
		try {
			memberService.memberUpdate(memberDto);
			MemberDto dto = memberService.memberDetail(memberDto.getMemberId());
			MessageDto message = new MessageDto();
			if (dto != null) { // 업데이트된 dto리턴
				message.setMessage(1);
				return new ResponseEntity<MessageDto> (message,HttpStatus.OK);
			} else {
				message.setMessage(0);
				return new ResponseEntity<MessageDto>(message, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	// 삭제 api : messageDto 반환
	@DeleteMapping("/memberDelete/{memberId}")
	public ResponseEntity<?> memberDelete(@PathVariable("memberId") String memberId) {
		try {
			memberService.memberDelete(memberId);
			MemberDto dto = memberService.memberDetail(memberId);
<<<<<<< HEAD
			if (dto == null) { // 성공
				//MessageDto message = new MessageDto(1);
				return new ResponseEntity<MemberDto>(list,HttpStatus.OK);				
=======
			MessageDto message = new MessageDto();
			if (dto == null) { // 성공
				message.setMessage(1);
				return new ResponseEntity<MessageDto>(message,HttpStatus.OK);				
>>>>>>> 44e5854354cca62055ea79df4e6cd0aec5ddee3c
			}
			else { // 정보가 없을때 지울경우
				message.setMessage(0);
				return new ResponseEntity<MessageDto>(message,HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
		

	// 비번찾기
	@GetMapping("/password/{memberId}")
	public String findById(@PathVariable("memberId") String memberId) throws Exception {
		return memberService.findById(memberId);
	}

	// 예외
	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
