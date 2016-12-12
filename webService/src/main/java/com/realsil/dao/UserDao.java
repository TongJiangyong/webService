package com.realsil.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.realsil.dao.interfaceGroup.IFrightRecordDao;
import com.realsil.dao.interfaceGroup.IUserDao;
import com.realsil.modal.FrightRecord;
import com.realsil.modal.User;
import com.realsil.service.UserService;

public class UserDao implements IUserDao  
{  
    public void add(User user)  
    {  
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IUserDao userDao=session.getMapper(IUserDao.class);
    	IFrightRecordDao frightRecordDao=session.getMapper(IFrightRecordDao.class);
    	//注意这里add了两次
    	//System.out.println("test:"+user.getLastLoginDate());

    	//这里的处理方法非常不好，以后再处理吧.....
    	FrightRecord frightRecord = new FrightRecord();
    	frightRecordDao.add(frightRecord);
    	user.setFrightRecord(frightRecordDao.getByDesc());
    	userDao.add(user);
    	//frightRecordDao.add(user.getFrightRecord());
	    session.commit();
    }  
    
    public User getById(int id){
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IUserDao userDao=session.getMapper(IUserDao.class);
	    User user = userDao.getById(id);
	    session.commit();
        return user;  
    }  
   
    public void delete(int id)  
    {  
        SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IUserDao userDao=session.getMapper(IUserDao.class);
	    userDao.delete(id);
        session.commit();// 提交事务  
    }  
  
    public void update(User user)  
    {  
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IUserDao userDao=session.getMapper(IUserDao.class);
    	IFrightRecordDao frightRecordDao=session.getMapper(IFrightRecordDao.class);
	    userDao.update(user); 
    	frightRecordDao.update(user.getFrightRecord());
	    session.commit();
    }  
  

	public List<User> getAll() {
		   SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
	       IUserDao userDao=session.getMapper(IUserDao.class);
	       List<User> users = userDao.getAll();
	       session.commit();
	       return users;  
	}

	public List<User> getByState(int state) {
		   SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
	       IUserDao userDao=session.getMapper(IUserDao.class);
	       List<User> users = userDao.getByState(state);
	       session.commit();
	       return users;  
	}
	
	

}  