package com.realsil.dao.interfaceGroup;

import java.util.List;

import com.realsil.modal.FrightRecord;
import com.realsil.modal.Room;
import com.realsil.modal.User;

public interface IRoomDao {
	public int add(Room room) ;
    public Room getById(int id);
    public void delete(int id);
    public void update(Room room);
	public Room getByDesc();
    public List<Room> getAll();
    public List<Room> getByState(int state);
}
