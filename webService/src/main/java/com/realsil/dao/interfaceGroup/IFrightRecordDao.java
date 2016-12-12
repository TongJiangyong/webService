package com.realsil.dao.interfaceGroup;

import java.util.List;

import com.realsil.modal.FrightRecord;
import com.realsil.modal.User;

public interface IFrightRecordDao {
	public void add(FrightRecord frightRecord) ;
    public FrightRecord getById(int id);
    public FrightRecord getByDesc();
    public void delete(int id);
    public void update(FrightRecord FrightRecord);
    public List<FrightRecord> getAll();
}
