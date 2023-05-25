package com.ssafy.edu.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.edu.member.model.dao.MemberMapper;
import com.ssafy.edu.member.model.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

	private final MemberMapper memberMapper;

	@Override
	public void join(MemberDto mdto) {
		memberMapper.join(mdto);
	}

	@Override
	public MemberDto login(MemberDto mdto) {
		return memberMapper.login(mdto);
	}

	@Override
	public List<MemberDto> memberlist() {
		return memberMapper.memberlist();
	}

	@Override
	public MemberDto memberDetail(String memberId) {
		return memberMapper.memberDetail(memberId);
	}

	@Override
	public void memberDelete(String memberId) {
		memberMapper.memberDelete(memberId);
	}

	@Override
	public void memberUpdate(MemberDto mdto) {
		memberMapper.memberUpdate(mdto);
	}

	@Override
	public String findById(String memberId) {
		return memberMapper.findById(memberId);
	}

	@Override
	public MemberDto loginMember(String memberId, String memberPassword) {
		return memberMapper.loginMember(memberId, memberPassword);
	}

	@Override
	public void saveRefreshToken(String memberId, String refreshToken) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", memberId);
		map.put("refreshToken", refreshToken);
		memberMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String memberId) {
		return memberMapper.getRefreshToken(memberId);
	}

	@Override
	public void deleRefreshToken(String memberId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", memberId);
		map.put("refreshToken", null);
		memberMapper.deleteRefreshToken(map);
	}

}
