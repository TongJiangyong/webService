package com.realsil.modal;

import java.util.Date;

public class Room {
	private int id;
	private User serverUser;
	private User clientUser;
	private int state; //1��һ����--�ȴ�״̬  2 ��������--����״̬  0 û����--�˳�״̬
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
