package com.news.entity;

public class User {
	private int id;//用户编号
	private String username;//用户名
	private String password;//密码
	private int power;
	//alt+shift+s
	public User() {
		super();
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public User(int id, String username, String password,int power) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.power = power;
	}
	
	public int getPower() {
		return power;
	}

	public int setPower(int power) {
		return this.power = power;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", power=" + power + "]";
	}

	
	
}
