package com.realsil.dao.interfaceGroup;

import java.util.List;

import com.realsil.modal.User;

public interface IUserDao {
	public void add(User user) ;
    public User getById(int id);
    public void  delete(int id);
    public void update(User user);
    public List<User> getAll();
    public List<User> getByState(int state);
}
