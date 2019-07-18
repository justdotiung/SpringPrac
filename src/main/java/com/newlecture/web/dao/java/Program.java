package com.newlecture.web.dao.java;

import com.newlecture.web.entity.File;

public class Program {
	public static void main(String[] args) {
		java.io.File directory = new java.io.File("D:\\html5-1902");
		
		java.io.File[] file = directory.listFiles();
		
		File f = new File(file[0]);
	
		System.out.println(f);
		
		 f = new File(file[1]);
		
		System.out.println(f);
	
		for (int i = 0; i < file.length; i++) {
			f= new File(file[i]);
			
		}
	}

}
