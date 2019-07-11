package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcMemberDao implements MemberDao {
	String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";

	@Override
	public Member get(String id) {
		Member member = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String sql = "select * from member where id = '" + id + "'";
			Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			if (rs.next()) {
				member = new Member(rs.getString("ID"), rs.getString("pwd"), rs.getString("name"), rs.getInt("gender"),
						rs.getInt("age"), rs.getString("birthday"), rs.getString("phone"), rs.getDate("regdate"));

			}

			rs.close();
			statement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	@Override
	public List<Member> getList() {
		Connection connection;
		Statement statement;
		List<Member> list = new ArrayList<Member>();
		String sql = "select * from member";
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Member member = new Member(rs.getString("ID"), rs.getString("pwd"), rs.getString("name"),
						rs.getInt("gender"), rs.getInt("age"), rs.getString("birthday"), rs.getString("phone"),
						rs.getDate("regdate"));
				list.add(member);

			}

			rs.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Member> getList(String query) {
		Connection connection;
		Statement statement;
		List<Member> list = new ArrayList<Member>();
		String sql = "select * from member where name like '%" + query + "%'";
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Member member = new Member(rs.getString("ID"), rs.getString("pwd"), rs.getString("name"),
						rs.getInt("gender"), rs.getInt("age"), rs.getString("birthday"), rs.getString("phone"),
						rs.getDate("regdate"));
				list.add(member);

			}

			rs.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

}
