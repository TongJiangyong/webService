package com.realsil.service;

import java.util.List;

import com.realsil.dao.UserDao;
import com.realsil.dao.interfaceGroup.IUserDao;
import com.realsil.dao.interfaceGroup.IUserService;
import com.realsil.modal.User;

public class UserService implements IUserService {

	IUserDao userDao = new UserDao();
	public boolean add(User user) {
		// TODO Auto-generated method stub
		try{
			this.userDao.add(user);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}

	}

	public User getById(int id) {
		// TODO Auto-generated method stub
		return this.userDao.getById(id);
	}

	public boolean delete(int id) {
		try{
			this.userDao.delete(id);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	public boolean update(User user) {
		try{
			this.userDao.update(user);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.userDao.getAll();
	}

	public List<User> getByState(int state) {
		// TODO Auto-generated method stub
		return this.userDao.getByState(state);
	}



}
