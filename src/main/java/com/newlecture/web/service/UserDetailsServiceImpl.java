package com.newlecture.web.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;
import com.newlecture.web.entity.MyUserDetails;


//security �� ����� Ȯ�� ��� (javaConfig �̿�) 
//Principal �� �ȴ�.
public class UserDetailsServiceImpl implements UserDetailsService{
	
	//Dao�� �������� ���� ���� �����ϰ� ������ش�.
	//service���������������ִ°��� �������̱⶧���� �ʵ尪���� �����ü��ִ�.
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyUserDetails userDetails = null;
		try {
//		member memebre = memberDao.getByEmail(username);
			Member member = memberDao.get(username);
			userDetails = new MyUserDetails(member);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(userDetails.getId());
		System.out.println(userDetails.getPw());
		System.out.println(userDetails.getAuthorities());
		
		//��ȯ���� UserDetails �������̽��� �����ϰ� �־�� �Ѵ� 
		//Member��ƼƼ�� �������� ������ �ϱ⺸�ٴ�(��Ű������ Ŭ�������� �������� ���ӵɼ��ֱ⶧����)
		//���ο� antity�� �������ش� (MyUserDetails)
		return userDetails;
	}

}
