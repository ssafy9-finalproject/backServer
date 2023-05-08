package com.ssafy.edu.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.edu.member.model.dto.MemberDto;

public interface MemberService {
	void join(MemberDto mdto) throws Exception;
	
	MemberDto login(MemberDto mdto) throws Exception;
	List<MemberDto> memberlist() throws Exception;
	MemberDto memberDetail(String memberId) throws Exception;
	void memberDelete(String memberId) throws Exception;
	void memberUpdate(MemberDto mdto) throws Exception;
	String findById(String memberId) throws Exception;
	MemberDto loginMember(String memberId, String memberPassword) throws Exception;
}
