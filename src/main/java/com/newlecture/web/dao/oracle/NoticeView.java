package com.newlecture.web.dao.oracle;

import java.util.Date;

import com.newlecture.web.entity.Notice;

public class NoticeView extends Notice {
	private int commentCount;

	public NoticeView() {
		// TODO Auto-generated constructor stub
	}
	public NoticeView(int id, String title, String writherId, Date date, int hit, int commentCount) {
		super(id, title, writherId, date, hit);
		this.commentCount = commentCount;
		// TODO Auto-generated constructor stub
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public NoticeView(int id, String title, String content, String writherId, Date date, int hit,int commentCount) {
		super(id, title, content, writherId, date, hit);
		// TODO Auto-generated constructor stub
	}
//	이따 다시구현 캡슐써보장
//	public String toJson() {
//		return "{\"id:" + id + 
//				", title:\"" + title + 
//				"\", content:\"" + content + 
//				"\", writherId:\"" + writherId + 
//				"\", hit:" + hit ;
//	}
}
