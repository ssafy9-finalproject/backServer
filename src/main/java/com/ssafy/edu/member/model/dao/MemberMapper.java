package com.ssafy.edu.member.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.edu.member.model.dto.MemberDto;


@Mapper
public interface MemberMapper {
	void join(MemberDto mdto) throws Exception;
	MemberDto login(MemberDto mdto) throws Exception;
	List<MemberDto> memberlist() throws Exception;
	MemberDto memberDetail(String memberId) throws Exception;
	void memberDelete(String memberId) throws Exception;
	void memberUpdate(MemberDto mdto) throws Exception;
	String findById(String memberId) throws Exception;
	MemberDto loginMember(String memberId, String memberPassword) throws Exception;
	
	public void saveRefreshToken(Map<String, String> map) throws SQLException;
	public Object getRefreshToken(String memberId) throws SQLException;
	public void deleteRefreshToken(Map<String, String> map) throws SQLException;
}
