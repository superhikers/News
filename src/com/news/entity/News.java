package com.news.entity;

import java.sql.Date;

public class News {
	private int id;
	private String title;
	private String type;
	private String content;
	private String author;
	private Date  date;
	private String img;
	
	public News(int id ,String title,String type,String content,String author,Date  date,String img) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.content = content;
		this.author = author;
		this.date = date;
		this.img = img;
	}
	public News() {
		
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", type=" + type + ", content=" + content + ", author=" + author
				+ ", date=" + date + ", img=" + img + "]";
	}
	
	
	
}
