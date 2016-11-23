package com.realsil.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.realsil.modal.User;
import com.realsil.service.IUserService;
import com.realsil.service.UserService;

public class UserDao implements IUserDao  
{  
    public void add(User user)  
    {  
        SqlSession session = GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
        try  
        {   
            session.commit();// 提交事务  
        } catch (Exception e)  
        {  
            e.printStackTrace();  
        } finally  
        {  
            session.close();  
        }  
    }  
    
    public User getById(int id){
    	SqlSession session = GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	User user = (User) session.selectOne("com.realsil.modal.selectUserById",id); 
        session.close();  
	    session.commit();
        return user;  
    }  
   
    public void delete(int id)  
    {  
        SqlSession session = GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
        try  
        {  
            session.getMapper(IUserService.class).delete(id);  
            session.commit();// 提交事务  
        } catch (Exception e)  
        {  
            e.printStackTrace();  
        } finally  
        {  
            session.close();  
        }  
    }  
  
    public int update(User user)  
    {  
        int count = 0;  
        SqlSession session = GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
        try  
        {  
            session.commit();// 提交事务  
        } catch (Exception e)  
        {  
            count = 0;  
            e.printStackTrace();  
        } finally  
        {  
            session.close();  
        }  
        return count;  
    }  
  

	public List<User> getAllUsers() {
		  SqlSession session = GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
	       IUserDao userDao=session.getMapper(IUserDao.class);
	       List<User> users = userDao.getAllUsers();
	       session.commit();
	       return users;  
	}  
}  