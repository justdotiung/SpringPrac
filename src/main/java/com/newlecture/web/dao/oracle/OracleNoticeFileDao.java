package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.entity.NoticeFile;

public class OracleNoticeFileDao implements NoticeFileDao {

	@Override
	public List<NoticeFile> getListByNoticeId(int noticeId) throws ClassNotFoundException, SQLException {
		List<NoticeFile> list = new ArrayList<>();
		
		String sql ="select * from notice_file where notice_id=?";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement statement = connection.prepareStatement(sql);
		// 실행하기전에 먼저 세팅해준다.
		statement.setInt(1, noticeId);
		
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			NoticeFile noticeFile = new NoticeFile(rs.getInt("id"), 
										rs.getString("name"),
										rs.getInt("notice_id")
										);

			list.add(noticeFile);
		}

		rs.close();
		statement.close();
		connection.close();

		return list;
	}

	@Override
	public int insert(NoticeFile noitceFile) throws ClassNotFoundException, SQLException {
	int result= 0;
		
		String sql = "insert into notice_file(id,name,notice_id)"
				+ " values(notice_file_seq.nextval,?,?)";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
	//	Statement statement = connection.createStatement();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, noitceFile.getName());
		statement.setInt(2, noitceFile.getNoticeId());
		//Statement는 sql을 넣어줘야 한다.
		//result=statement.executeUpdate(sql);
		result=statement.executeUpdate();
		statement.close();
		connection.close();

		return result;
	}

	@Override
	public int update(NoticeFile noitceFile) throws ClassNotFoundException, SQLException {
	int result= 0;
		
		String sql = "update notice_file set name = ?, notice_id= ? where id =? ";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
	//	Statement statement = connection.createStatement();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, noitceFile.getName());
		statement.setInt(2, noitceFile.getNoticeId());
		statement.setInt(3, noitceFile.getId());
		
//		result=statement.executeUpdate(sql);
		result=statement.executeUpdate();
		statement.close();
		connection.close();

		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result= 0;
		
		String sql = "delete notice_file where id =? ";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
	//	Statement statement = connection.createStatement();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		
//		result=statement.executeUpdate(sql);
		result=statement.executeUpdate();
		statement.close();
		connection.close();

		return result;
	}

}
