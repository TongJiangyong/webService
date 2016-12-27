package com.realsil.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.realsil.dao.interfaceGroup.IFrightRecordDao;
import com.realsil.dao.interfaceGroup.IRoomDao;
import com.realsil.modal.FrightRecord;
import com.realsil.modal.Room;

public class RoomDao implements IRoomDao
{

	public int add(Room room) {
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IRoomDao roomDao=session.getMapper(IRoomDao.class);
    	roomDao.add(room);	 
	    session.commit();
    	//����Ĵ������ǳ����ã��Ժ��ٴ����.....
    	Room roomReturn = roomDao.getByDesc();
        return roomReturn.getId(); 
	}

	public Room getById(int id) {
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IRoomDao roomDao=session.getMapper(IRoomDao.class);
    	Room room = roomDao.getById(id);
	    session.commit();
        return room;  
	}

	public void delete(int id) {
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IRoomDao roomDao=session.getMapper(IRoomDao.class);
    	roomDao.delete(id);
        session.commit();// �ύ����  
		
	}

	public void update(Room room) {
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IRoomDao roomDao=session.getMapper(IRoomDao.class);
    	roomDao.update(room); 
	    session.commit();

	}

	public List<Room> getAll() {
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IRoomDao roomDao=session.getMapper(IRoomDao.class);
    	List<Room> rooms = roomDao.getAll();
    	session.commit();
    	return rooms; 
	}

	public List<Room> getByState(int state) {
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IRoomDao roomDao=session.getMapper(IRoomDao.class);
    	List<Room> rooms = roomDao.getByState(state);
    	session.commit();
    	return rooms; 
	}  
	
	public Room getByDesc() {
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IRoomDao roomDao=session.getMapper(IRoomDao.class);
    	Room room = roomDao.getByDesc();
	    session.commit();	
        return room;  
	}


}  