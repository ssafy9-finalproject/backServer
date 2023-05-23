package com.ssafy.edu.member.model.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Table(name = "T-USER")
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_SEQUENCD_ID")
	private Long userSequenceId;
	
	@Column(name = "USER_EMAIL", nullable = false, length = 100, unique = true)
	private String userEmail;
	
	@Column(name="USER_BIRTH", length=6)
	private String userBirth;
	
	@Column(name="USER_NICKNAME", length=15)
	private String userNickname;
}
