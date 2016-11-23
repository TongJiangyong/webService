package com.realsil.dao;

import java.util.List;

import com.realsil.modal.User;

public interface IUserDao {
	public void add(User user) ;
    public User getById(int id);
    public void delete(int id);
    public int update(User user);
    public List<User> getAllUsers();
}
