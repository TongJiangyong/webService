package com.realsil.service;

import java.util.List;

import com.realsil.dao.FrightRecordDao;
import com.realsil.dao.interfaceGroup.IFrightRecordDao;
import com.realsil.dao.interfaceGroup.IFrightRecordService;
import com.realsil.modal.FrightRecord;

public class FrightRecordService implements IFrightRecordService {

	IFrightRecordDao frightRecordDao = new FrightRecordDao();
	public boolean add(FrightRecord frightRecord) {
		// TODO Auto-generated method stub
		try{
			this.frightRecordDao.add(frightRecord);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}

	}

	public FrightRecord getById(int id) {
		// TODO Auto-generated method stub
		return this.frightRecordDao.getById(id);
	}

	public boolean delete(int id) {
		try{
			this.frightRecordDao.delete(id);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	public boolean update(FrightRecord frightRecord) {
		try{
			this.frightRecordDao.update(frightRecord);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	public List<FrightRecord> getAll() {
		// TODO Auto-generated method stub
		return this.frightRecordDao.getAll();
	}



}
