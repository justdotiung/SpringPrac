package com.newlecture.web.dao;


import java.lang.reflect.InvocationTargetException;
import java.util.List;
import com.newlecture.web.entity.File;

public interface FileDao {
	List<File> getList(String path);

	String getJSONList(String path) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException,
			SecurityException, InvocationTargetException;
}
