package com.ssafy.edu.member.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberDto {
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

	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", emailId=" + emailId + ", emailDomain=" + emailDomain
				+ ", nickname=" + nickname + ", password=" + password + ", phoneNumber=" + phoneNumber + ", createdAt="
				+ createdAt + ", modifiedAt=" + modifiedAt + ", memberRole=" + memberRole + ", status=" + status + "]";
	}

}
