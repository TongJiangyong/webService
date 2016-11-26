package com.realsil.dao.interfaceGroup;

import java.util.List;

import com.realsil.modal.User;

public interface IUserService {
	public boolean add(User user) ;
    public User getById(int id);
    public boolean  delete(int id);
    public boolean update(User user);
    public List<User> getAll();
    public List<User> getByState(int state);
}
