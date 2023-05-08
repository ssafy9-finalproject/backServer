package com.ssafy.edu.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.edu.member.model.dao.MemberMapper;
import com.ssafy.edu.member.model.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberMapper memberMapper;
	
	
	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

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
		System.out.println(memberId);
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

}
