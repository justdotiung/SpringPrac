package com.newlecture.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.newlecture.web.entity.Member;



public interface MemberDao {
		Member get(String id) throws ClassNotFoundException, SQLException;
	   List<Member> getList() throws ClassNotFoundException, SQLException;
	   List<Member> getList(String query) throws ClassNotFoundException, SQLException;
}
