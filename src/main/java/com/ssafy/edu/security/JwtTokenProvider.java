package com.ssafy.edu.security;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.ssafy.edu.member.service.MemberService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
	private String secretKey = "ssafySecret";
	
	private long tokenValidTime = 1000 * 60 * 10L;
	
	private final UserDetailsService userDetailsService;
	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	public String createToken(String memberId, String memberRole) {
		Claims claims = Jwts.claims().setSubject(memberId);
		claims.put("roles", memberRole);
		Date now = new Date();
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(new Date(System.currentTimeMillis() + tokenValidTime))
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}
	
	public Authentication getAuthentication(String token) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(this.u)
	}
	
}
