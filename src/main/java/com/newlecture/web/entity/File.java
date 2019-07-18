package com.newlecture.web.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

public class File {
	private boolean isFile;
	private String name;
	private String type;
	private long size;
	private Date createdDate;
	
	
	public File(java.io.File file) {
		name = file.getName();
		size = file.length();
		type = name.substring(name.lastIndexOf("."));
		
		try {
			BasicFileAttributes fatter = 
					Files.readAttributes(file.toPath(), BasicFileAttributes.class);
			//디렉토리의 파일 시간을 받을수 있다 수정과 등로 등등... 정보를 갖고올수있다.
			createdDate = new Date(fatter.creationTime().toMillis());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fromFile(java.io.File file) {
		name = file.getName();
	}
	
	public String toJSON() {
		
		return "{}";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "File [name=" + name + ", type=" + type + ", size=" + size + ", createdDate=" + createdDate + "]";
	}
	
	
	
}
