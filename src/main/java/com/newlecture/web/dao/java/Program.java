package com.newlecture.web.dao.java;

import java.lang.reflect.InvocationTargetException;

import com.newlecture.web.entity.File;

public class Program {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		java.io.File directory = new java.io.File("D:\\html5-1902");
		
		java.io.File[] file = directory.listFiles();
	
		for (int i = 0; i < file.length; i++) {
			File f= new File(file[i]);
			System.out.println(f.toJSON());
		}
	}

}
