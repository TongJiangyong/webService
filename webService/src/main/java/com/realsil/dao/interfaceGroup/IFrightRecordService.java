package com.realsil.dao.interfaceGroup;

import java.util.List;

import com.realsil.modal.FrightRecord;
import com.realsil.modal.User;

public interface IFrightRecordService {
	public boolean add(FrightRecord frightRecord) ;
    public FrightRecord getById(int id);
    public boolean delete(int id);
    public boolean update(FrightRecord FrightRecord);
    public List<FrightRecord> getAll();
}
