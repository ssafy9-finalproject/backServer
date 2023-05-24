package com.ssafy.edu.member.model.dto;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

<<<<<<< HEAD
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

=======
>>>>>>> 70fdfe84bfb19f3243c1925c1b181b8a5fc67085
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
<<<<<<< HEAD
public class MemberDto implements UserDetails{
=======
public class MemberDto{
>>>>>>> 70fdfe84bfb19f3243c1925c1b181b8a5fc67085
	private String memberId; // 아이디
	private String emailId; // 이메일 아이디
	private String emailDomain; // 이메일 도메인
	private String nickname; // 닉네임
	private String password; // 비밀번호
	private String phoneNumber; // 전화번호
	
	private String createdAt; // 생성 날짜
	private String modifiedAt; // 수정 날짜
	
	private char memberRole; // 사용자 역할
	private char status; // 삭제 상태 
	
	
	
	public MemberDto(String memberId, String emailId, String emailDomain, String nickname, String password,
			String phoneNumber) {
		super();
		this.memberId = memberId;
		this.emailId = emailId;
		this.emailDomain = emailDomain;
		this.nickname = nickname;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	// 아이디 찾기
	public MemberDto(String memberId, String password) {
		super();
		this.memberId = memberId;
		this.password = password;
	}
<<<<<<< HEAD

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return memberId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

=======
>>>>>>> 70fdfe84bfb19f3243c1925c1b181b8a5fc67085
}
