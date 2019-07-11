package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class JDBCProgram {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scan = new Scanner(System.in);
		String query = scan.nextLine();
		
	JdbcMemberDao d = new JdbcMemberDao();
	Member b = d.get("newlec");
	System.out.println(b.getPwd());
	List<Member> a = d.getList(query);
	for(Member e : a)
		System.out.println(e.toString());
	}
}
