package com.newlecture.web.entity;

public class NoticeFile {
	private int id;
	private String name;
	private int noticeId;
	
	
	
	public NoticeFile() {
	}
	
//	for inserting
	public NoticeFile(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
//	for selecting
	public NoticeFile(int id, String name, int noticeId) {
		super();
		this.id = id;
		this.name = name;
		this.noticeId = noticeId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
}
