package com.newlecture.web.dao.oracle;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String writherId;
	private String content;
	private Date date;
	private int hit;
	public Notice() {
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Notice(String[] args) {
		this.id =Integer.parseInt(args[0]);
		this.title = args[1];
		this.writherId = args[2];
		this.date = new Date(args[3]);
		this.hit = Integer.parseInt(args[4]);
	}
	public Notice(int id, String title, String writherId, Date date, int hit) {
		this.id = id;
		this.title = title;
		this.writherId = writherId;
		this.date = date;
		this.hit = hit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWritherId() {
		return writherId;
	}
	public void setWritherId(String writherId) {
		this.writherId = writherId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Notice(int id, String title, String writherId, String content, Date date, int hit) {
		super();
		this.id = id;
		this.title = title;
		this.writherId = writherId;
		this.content = content;
		this.date = date;
		this.hit = hit;
	}
	
	
	
}
