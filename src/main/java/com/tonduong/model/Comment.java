package com.tonduong.model;

public class Comment extends AbstractModel {
	private Integer iduser;
	private Integer idnews;
	private String content;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public Integer getIduser() {
		return iduser;
	}
	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}
	public Integer getIdnews() {
		return idnews;
	}
	public void setIdnews(Integer idnews) {
		this.idnews = idnews;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
