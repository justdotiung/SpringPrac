package com.newlecture.web.dao.oracle;

import java.sql.SQLException;
import java.util.List;

public interface MemberDao {
	   List<Member> getList() throws ClassNotFoundException, SQLException;
	   List<Member> getList(String query) throws ClassNotFoundException, SQLException;
	
	   Member get(String id) throws ClassNotFoundException, SQLException;
}
