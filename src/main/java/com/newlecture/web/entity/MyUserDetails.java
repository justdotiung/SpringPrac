package com.newlecture.web.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class MyUserDetails /* �α��� ���� ��������  */ 
			extends Member 
			implements UserDetails{
	
	public MyUserDetails() {
	}
	//�÷���� ��ƼƼ ��Ʈ���� ���ƾ� ���ε����ش�.
	public MyUserDetails(Member member) {
		setId(member.getId());
		setName(member.getName());
		setPw(member.getPw());
		setAge(member.getAge());
		setPhone(member.getPhone());
		//setAuthority(member.getAuthority());
	}
	
	
	
	
	//�������� ============
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		"ROLE_ADMIN" "ROLE_STUDENT"
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"/*getAuthority()*/));
		//authorities.add(new SimpleGrantedAuthority("STUDENT"));
		
		return authorities;
	}

	//����������============
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

	//���� ����� �Ϸ�
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

	//���� ����� Ȱ��ȭ
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
