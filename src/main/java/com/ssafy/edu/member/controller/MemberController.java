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

// 화면이동 컨트롤러. 차근차근 없애기
@Controller
@CrossOrigin("*")
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberService;
 
	public MemberController(MemberService memberService) 
	{
		this.memberService = memberService; 
	}
		
	// 회원 리스트 조회
	@GetMapping("/memberlist")
	@ResponseBody
	public List<MemberDto> memberlist() throws Exception {
		return memberService.memberlist();
	}
	
	// 회원 상세
	@GetMapping("/memberdetail/{memberId}")
	@ResponseBody
	public MemberDto memberdetail(@PathVariable("memberId") String memberId) throws Exception {
		return memberService.memberDetail(memberId);	
	}
	
	
	// 회원 수정
	@PutMapping("/memberupdate")
	public ResponseEntity<?> memberupdate(@RequestBody MemberDto memberDto){
		try {
			memberService.memberUpdate(memberDto);
			MemberDto dto = memberService.memberDetail(memberDto.getMemberId());
			if (dto != null) { // 업데이트된 dto리턴
				return new ResponseEntity<MemberDto> (dto,HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
//	public void memberUpdate(@RequestBody MemberDto memberDto) throws Exception {
//		memberService.memberUpdate(memberDto);
//	}
	
//	// 삭제 api
//	@DeleteMapping("/memberDelete/{memberId}")
//	public void memberDelete(@PathVariable("memberId") String memberId) throws Exception {
//		memberService.memberDelete(memberId);
//	}
	
	
	
	// 삭제 api
	@DeleteMapping("/memberDelete/{memberId}")
	public ResponseEntity<?> memberDelete(@PathVariable("memberId") String memberId) {
		try {
			memberService.memberDelete(memberId);
			MemberDto dto = memberService.memberDetail(memberId);
			if (dto == null) { // 성공
				//MessageDto message = new MessageDto(1);
				return new ResponseEntity<MemberDto>(list,HttpStatus.OK);				
			}
			else { // 정보가 없을때 지울경우
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
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
