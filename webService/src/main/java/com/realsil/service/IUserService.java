package com.realsil.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.realsil.modal.User;

public interface IUserService {  
    @Insert(" insert into users (id,username,password) values (#{id},#{username},#{password})")  
    void add(@Param("id")int id,@Param("username") String username,@Param("password")String password);  
 
    @Delete(" delete from users where id=#{id}")   
    void delete(int id);  
 
    @Update(" update users set username=#{username},password=#{password} where id=#{id}")  
    int update(@Param("username") String username,@Param("password")String password,@Param("id")int id);  
 
    @Select(" select * from users where id=#{id}")  
    User getUser(int id);  
 
    @Select(" select * from users order by id asc ")  
    List<User> getUsers();   
 
    @Select(" select * from users order by id asc limit #{pageSize} offset #{offset} ")  
    List<User> getUsersByPage(@Param("offset")int offset,@Param("pageSize") int pageSize);//offset=pageSize*(page-1)}?  
}  
