package com.ssafy.edu.member.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.member.model.dto.MemberDto;
import com.ssafy.edu.member.service.JwtService;
import com.ssafy.edu.member.service.MemberService;
import com.ssafy.edu.utils.ApiUtils;
import com.ssafy.edu.utils.ApiUtils.ApiResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// 화면이동 컨트롤러. 차근차근 없애기
@Slf4j // 롬복 로깅 라이브러리
@RestController
@RequiredArgsConstructor // MemberService를 한번 생성하고 바꿀필요없으므로 final, RequiredArgsConstructor사용
@CrossOrigin("*")
public class MemberController {

	private final JwtService jwtService;
	private final MemberService memberService;
	
	// 응답 데이터: ResponseEntity로 전환
	// 회원 리스트 조회 : 리스트 반환
	@GetMapping("/auth")
	public ApiResult<?> checkAuth() {
		return ApiUtils.success(null);
	}
	
	@GetMapping("/memberlist")
	public ResponseEntity<?> memberlist(HttpServletRequest request) {
		
		List<MemberDto> list = memberService.memberlist();
			// 멤버리스트는 원소가 아무것도없어도 호출이 되어야한다.
		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
		
	}
	
	// 회원 상세 : dto 반환
	@GetMapping("/memberdetail/{memberId}")
	public ResponseEntity<?> memberdetail(@PathVariable("memberId") String memberId
			, HttpServletRequest request){
		log.debug("memberdetail 진입");
		MemberDto dto = null;
		// id가 관리자일때
		String token = request.getHeader("access-token");
		String id = jwtService.getMemberId(token);
		if (id.equals("admin")) {
			
				// 해당 사용자가 있어야함 : 상세 정보 전송
			dto = memberService.memberDetail(memberId);
			return new ResponseEntity<MemberDto>(dto, HttpStatus.OK);
			
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	// 회원 수정 : messageDto 반환
	@PutMapping("/memberupdate")
	public ResponseEntity<?> memberupdate(@RequestBody MemberDto memberDto
			, HttpServletRequest request){
		String token = request.getHeader("access-token");
		String id = jwtService.getMemberId(token);
		// id랑 memberId랑 일치할때
		if (id.equals(memberDto.getMemberId())) {
			// 업데이트
			memberService.memberUpdate(memberDto);
			MemberDto updateResponseDto = memberService.memberDetail(memberDto.getMemberId());
			if (updateResponseDto != null) { // 업데이트된 dto리턴
				return new ResponseEntity<MemberDto> (updateResponseDto,HttpStatus.OK);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	// 삭제 api : messageDto 반환
	@DeleteMapping("/memberDelete/{memberId}")
	public ResponseEntity<?> memberDelete(@PathVariable("memberId") String memberId
			, HttpServletRequest request) {
		String token = request.getHeader("access-token");
		// id가 관리자일때
		String id = jwtService.getMemberId(token);
		if (id.equals("admin")) {
			
				memberService.memberDelete(memberId);
				return new ResponseEntity<Void>(HttpStatus.OK);				
			
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
//	@PostMapping("/token")
//	public Map<String,Object> getMemberId(@RequestBody AccessTokenDto accessToken) {
//		//log.info("1: " + accessToken.toString());
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("message", "success");
//		String memberId = jwtService.getMemberId(accessToken.getAccessToken());
//		map.put("memberId", memberId);
//		//log.info("2:" + memberId);
//		return map;
//	}
		

	// 비번찾기
	@GetMapping("/password/{memberId}")
	public String findById(@PathVariable("memberId") String memberId) throws Exception {
		return memberService.findById(memberId);
	}

}
