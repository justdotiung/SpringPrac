package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
//@Repository
public class OracleNoticeDao implements NoticeDao  {

	@Override
	public List<NoticeView> getList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(1, "title", "");
	}

	@Override
	public List<NoticeView> getList(int page) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		return getList(page, "title", "");
	}

	@Override
	public List<NoticeView> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		List<NoticeView> list = new ArrayList<>();
		
		int pagesize =10;
		int start = 1+(page-1)*pagesize ; // 1, 11 , 21, 31, ...
		int end =page*10;	// 10, 20, 30, 40 ....
		
		String sql ="select * from notice_view "
				+ "where "+field+" like ? and num between ? and ?";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement statement = connection.prepareStatement(sql);
		// 실행하기전에 먼저 세팅해준다.
		statement.setString(1, "%"+query+"%");
		statement.setInt(2, start);
		statement.setInt(3, end);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			NoticeView notice = new NoticeView(rs.getInt("id"), 
										rs.getString("title"),
										rs.getString("writer_id"),
										rs.getDate("regdate"),
										rs.getInt("hit"),
										rs.getInt("comment_count"));

			list.add(notice);
		}

		rs.close();
		statement.close();
		connection.close();

		return list;
	}

	@Override
	public Notice get(int id) throws ClassNotFoundException, SQLException {
		Notice notice = null;

		String sql = "select * from notice where id =" + id;
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		if (rs.next()) {
			notice = new Notice(rs.getInt("id"), rs.getString("title"),rs.getString("content"), rs.getString("writer_id"), rs.getDate("regdate"),
					rs.getInt("hit"));
		}

		rs.close();
		statement.close();
		connection.close();

		return notice;
	}

	@Override
	public Notice getPrev(int id) throws ClassNotFoundException, SQLException {
		String sql = " select * from (select * from notice_view order by regdate desc) " + 
				"where regdate < (select regdate from notice where id = "+id+") and rownum=1";
		Notice notice = null;

		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		if (rs.next()) {
			notice = new Notice(rs.getInt("id"), rs.getString("title"), rs.getString("writer_id"), rs.getDate("regdate"),
					rs.getInt("hit"));
		}

		rs.close();
		statement.close();
		connection.close();

		return notice;
	}


	@Override
	public Notice getNext(int id) throws ClassNotFoundException, SQLException {
		String sql = " select * from (select * from notice_view order by regdate) "
				+ "where regdate > (select regdate from notice where id = " + id + ") and rownum=1";
		Notice notice = null;

		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		if (rs.next()) {
			notice = new Notice(rs.getInt("id"), rs.getString("title"), rs.getString("writer_id"), rs.getDate("regdate"),
					rs.getInt("hit"));
		}

		rs.close();
		statement.close();
		connection.close();

		return notice;
	}

	@Override
	public int insert(Notice noitce) throws ClassNotFoundException, SQLException {
		int result= 0;
		
		String sql = "insert into notice(id,title,content,writer_id)"
				+ " values(notice_seq.nextval,?,?,'mance')";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
	//	Statement statement = connection.createStatement();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, noitce.getTitle());
		statement.setString(2, noitce.getContent());
		//Statement는 sql을 넣어줘야 한다.
		//result=statement.executeUpdate(sql);
		result=statement.executeUpdate();
		statement.close();
		connection.close();

		return result;
	}

	@Override
	public int update(Notice noitce) throws ClassNotFoundException, SQLException {
		int result= 0;
		
		String sql = "update notice set title = ?, content = ? where id =? ";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
	//	Statement statement = connection.createStatement();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, noitce.getTitle());
		statement.setString(2, noitce.getContent());
		statement.setInt(3, noitce.getId());
		
//		result=statement.executeUpdate(sql);
		result=statement.executeUpdate();
		statement.close();
		connection.close();

		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		int result= 0;
		
		String sql = "delete notice where id =? ";
		
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

	@Override
	public int getLastId() throws ClassNotFoundException, SQLException {
		int result = -1;
		String sql = "select id from (select * from notice order by regdate desc) where rownum = 1";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);

		if (rs.next()) {
			result =rs.getInt("id");
		}

		rs.close();
		statement.close();
		connection.close();

		return result;
	}

	@Override
	public int getCount() throws ClassNotFoundException, SQLException {
		
		return 0;
	}

	@Override
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException {
		int count=0;
		String sql = "select count(id) count from notice where "+field+"like ?";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection(url, "\"newlec\"", "l4class");
	//	Statement statement = connection.createStatement();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "%"+query+"%");
		//Statement는 sql을 넣어줘야 한다.
		//result=statement.executeUpdate(sql);
		ResultSet rs = statement.executeQuery();
		while(rs.next())
			count = rs.getInt("count");

 		rs.close();	
		statement.close();
		connection.close();

		return count;

	}
	
}
