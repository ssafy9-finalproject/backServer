package com.ssafy.edu.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.edu.member.model.dto.MemberDto;

public interface MemberService {
	void join(MemberDto mdto);
	
	MemberDto login(MemberDto mdto);
	List<MemberDto> memberlist();
	MemberDto memberDetail(String memberId);
	void memberDelete(String memberId);
	void memberUpdate(MemberDto mdto);
	String findById(String memberId);
	MemberDto loginMember(String memberId, String memberPassword);
	
	public void saveRefreshToken(String memberId, String refreshToken);
	public Object getRefreshToken(String memberId);
	public void deleRefreshToken(String memberId);
}
