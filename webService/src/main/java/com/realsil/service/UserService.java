package com.realsil.service;

import java.util.List;

import com.realsil.dao.UserDao;
import com.realsil.modal.User;

public class UserService implements IUserService {

	//UserDao userDao = new UserDao();
	public void add(int id, String username, String password) {
		// TODO Auto-generated method stub
		//userDao.add(id, username, password);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public int update(String username, String password, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getUsersByPage(int offset, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
