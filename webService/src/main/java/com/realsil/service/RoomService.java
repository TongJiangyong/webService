package com.realsil.service;

import java.util.List;

import com.realsil.dao.RoomDao;
import com.realsil.dao.UserDao;
import com.realsil.dao.interfaceGroup.IRoomDao;
import com.realsil.dao.interfaceGroup.IRoomService;
import com.realsil.dao.interfaceGroup.IUserService;
import com.realsil.modal.Room;
import com.realsil.modal.User;

public class RoomService implements IRoomService {

	IRoomDao roomDao = new RoomDao();
	public int add(Room room) {
		// TODO Auto-generated method stub
		try{
			return this.roomDao.add(room);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("error info:"+e);
			return 0;
		}

	}

	public Room getById(int id) {
		// TODO Auto-generated method stub
		return this.roomDao.getById(id);
	}

	public boolean delete(int id) {
		try{
			this.roomDao.delete(id);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	public boolean update(Room room) {
		try{
			this.roomDao.update(room);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	public List<Room> getAll() {
		// TODO Auto-generated method stub
		return this.roomDao.getAll();
	}

	public List<Room> getByState(int state) {
		// TODO Auto-generated method stub
		return this.roomDao.getByState(state);
	}



}
