package com.newlecture.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;


public interface NoticeDao {
	List<NoticeView> getList() throws ClassNotFoundException, SQLException;
	List<NoticeView> getList(Integer page) throws ClassNotFoundException, SQLException;
	//@Select("select * from notice_view where ${field} like '%${query}%' and num between 1+(#{page}-1)*10 and #{page}*10")
	List<NoticeView> getList(@Param("page")Integer page, @Param("field")String field, @Param("query")String query) throws ClassNotFoundException, SQLException;
	
	//@Select("select * from notice where id = #{id}")
	Notice get(int id) throws ClassNotFoundException, SQLException;
	Notice getPrev(int id) throws ClassNotFoundException, SQLException;
	Notice getNext(int id) throws ClassNotFoundException, SQLException;

	int insert(Notice noitce) throws ClassNotFoundException, SQLException;
	int update(Notice noitce) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
	int getLastId() throws ClassNotFoundException, SQLException;
	
	int getCount() throws ClassNotFoundException, SQLException;
	int getCount(String field, String query) throws ClassNotFoundException, SQLException;

}
