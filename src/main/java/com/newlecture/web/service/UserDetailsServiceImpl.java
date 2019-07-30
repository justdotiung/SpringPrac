package com.newlecture.web.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;
import com.newlecture.web.entity.MyUserDetails;


//security 의 사용자 확장 방법 (javaConfig 이용) 
//Principal 이 된다.
public class UserDetailsServiceImpl implements UserDetailsService{
	
	//Dao로 쿼리문을 위임 좀더 느슨하게 만들어준다.
	//service의정보를가지고있는것이 쿼리문이기때문에 필드값으로 가져올수있다.
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
		
		//반환값이 UserDetails 인터페이스를 구현하고 있어야 한다 
		//Member엔티티에 직접적인 구현을 하기보다는(패키지들의 클래스들이 스프링에 종속될수있기때문에)
		//새로운 antity를 구현해준다 (MyUserDetails)
		return userDetails;
	}

}
