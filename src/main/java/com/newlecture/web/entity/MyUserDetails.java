package com.newlecture.web.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class MyUserDetails /* 로그인 정보 권한정보  */ 
			extends Member 
			implements UserDetails{
	
	public MyUserDetails() {
	}
	//컬럼명과 엔티티 필트명이 같아야 바인딩해준다.
	public MyUserDetails(Member member) {
		setId(member.getId());
		setName(member.getName());
		setPw(member.getPw());
		setAge(member.getAge());
		setPhone(member.getPhone());
		//setAuthority(member.getAuthority());
	}
	
	
	
	
	//권한정보 ============
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		"ROLE_ADMIN" "ROLE_STUDENT"
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"/*getAuthority()*/));
		//authorities.add(new SimpleGrantedAuthority("STUDENT"));
		
		return authorities;
	}

	//인증정보들============
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getPw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getId();
	}

	//현재 사용자 완료
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//현재 사용자 활성화
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
