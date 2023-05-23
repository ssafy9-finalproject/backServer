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
	public void join(MemberDto mdto) throws Exception {
		memberMapper.join(mdto);
	}

	@Override
	public MemberDto login(MemberDto mdto) throws Exception {
		return memberMapper.login(mdto);
	}

	@Override
	public List<MemberDto> memberlist() throws Exception {
		return memberMapper.memberlist();
	}

	@Override
	public MemberDto memberDetail(String memberId) throws Exception {
		return memberMapper.memberDetail(memberId);
	}

	@Override
	public void memberDelete(String memberId) throws Exception {
		memberMapper.memberDelete(memberId);
	}

	@Override
	public void memberUpdate(MemberDto mdto) throws Exception {
		memberMapper.memberUpdate(mdto);
	}

	@Override
	public String findById(String memberId) throws Exception {
		return memberMapper.findById(memberId);
	}

	@Override
	public MemberDto loginMember(String memberId, String memberPassword) throws Exception {
		return memberMapper.loginMember(memberId, memberPassword);
	}

	@Override
	public void saveRefreshToken(String memberId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", memberId);
		map.put("refreshToken", refreshToken);
		memberMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String memberId) throws Exception {
		return memberMapper.getRefreshToken(memberId);
	}

	@Override
	public void deleRefreshToken(String memberId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", memberId);
		map.put("refreshToken", null);
		memberMapper.deleteRefreshToken(map);
	}

}
