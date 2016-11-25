package com.realsil.modal;

import java.util.Date;

public class Room {
	private int id;
	private User serverUser;
	private User clientUser;
	private int state; //1有一个人--等待状态  2 有两个人--进行状态  0 没有人--退出状态
	private Date creatTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public User getServerUser() {
		return serverUser;
	}
	public void setServerUser(User serverUser) {
		this.serverUser = serverUser;
	}
	public User getClientUser() {
		return clientUser;
	}
	public void setClientUser(User clientUser) {
		this.clientUser = clientUser;
	}
	
	

}
