package com.newlecture.web.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

@Repository
public class MybatisMemberDao implements MemberDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Member get(String id) throws ClassNotFoundException, SQLException {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		return dao.get(id);
	}

	@Override
	public List<Member> getList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getList(String query) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Member member) {
		System.out.println(member.getPw());
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		return dao.insert(member);
	}


}
