package com.realsil.dao.interfaceGroup;

import java.util.List;

import com.realsil.modal.FrightRecord;
import com.realsil.modal.Room;
import com.realsil.modal.User;

public interface IRoomService {
	public int add(Room room) ;
    public Room getById(int id);
    public boolean delete(int id);
    public boolean update(Room room);
    public List<Room> getAll();
    public List<Room> getByState(int state);
}
