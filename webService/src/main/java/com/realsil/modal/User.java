package com.realsil.modal;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private String password;
	private Date registerDate;
	private Date lastLoginDate;
	private FrightRecord frightRecord;
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
	public FrightRecord getFrightRecord() {
		return frightRecord;
	}
	public void setFrightRecord(FrightRecord frightRecord) {
		this.frightRecord = frightRecord;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	

	
}
