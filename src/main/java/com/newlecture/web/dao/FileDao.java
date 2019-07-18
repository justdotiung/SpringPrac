package com.newlecture.web.dao;


import java.util.List;
import com.newlecture.web.entity.File;

public interface FileDao {
	List<File> getList(String path);
}
