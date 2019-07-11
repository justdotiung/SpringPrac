package com.newlecture.web.entity;

public class Member {

	private String id;
	private String pw;
	private String name;
	private int gender;
	private int age;
	private String birthday;
	private String phone;
	private String regdate;
	private String boss_Id;
	private String type;
	
	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public Member(String id, String pw, String name, int gender, int age, String birthday, String phone, String regdate,
			String boss_Id, String type) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.birthday = birthday;
		this.phone = phone;
		this.regdate = regdate;
		this.boss_Id = boss_Id;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getBoss_Id() {
		return boss_Id;
	}

	public void setBoss_Id(String boss_Id) {
		this.boss_Id = boss_Id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
