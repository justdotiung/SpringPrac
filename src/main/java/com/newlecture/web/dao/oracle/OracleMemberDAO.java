package com.newlecture.web.dao.oracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

public class OracleMemberDAO implements MemberDao {

	@Override
	public Member get(String id) throws ClassNotFoundException, SQLException {
		Member member= null;
		String sql = "select id, pwd from member where id = ?";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
	
		PreparedStatement pt = connection.prepareStatement(sql);
		pt.setString(1, id);
		ResultSet rs = pt.executeQuery();
		while(rs.next())
		{
			member = new Member(rs.getString("id"),rs.getString("pwd"));
		}
		rs.close();
		pt.close();
		connection.close();
	
		return member;
	}

	@Override
	public List<Member> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getList(String query) {
		// TODO Auto-generated method stub
		return null;
	}



}
