package com.realsil.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.realsil.dao.interfaceGroup.IFrightRecordDao;
import com.realsil.modal.FrightRecord;

public class FrightRecordDao implements IFrightRecordDao  
{

	public void add(FrightRecord frightRecord) {
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IFrightRecordDao frightRecordDao=session.getMapper(IFrightRecordDao.class);
    	frightRecordDao.add(frightRecord);
	    session.commit();
		
	}

	public FrightRecord getById(int id) {
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IFrightRecordDao frightRecordDao=session.getMapper(IFrightRecordDao.class);
    	FrightRecord frightRecord = frightRecordDao.getById(id);
	    session.commit();
        return frightRecord;  
	}

	public void delete(int id) {
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IFrightRecordDao frightRecordDao=session.getMapper(IFrightRecordDao.class);
    	frightRecordDao.delete(id);
        session.commit();// 提交事务  
	}

	public void update(FrightRecord frightRecord) {
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IFrightRecordDao frightRecordDao=session.getMapper(IFrightRecordDao.class);
    	frightRecordDao.update(frightRecord); 
	    session.commit();
	}

	public List<FrightRecord> getAll() {
    	SqlSession session = A_GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();  
    	IFrightRecordDao frightRecordDao=session.getMapper(IFrightRecordDao.class);
       List<FrightRecord> frightRecords = frightRecordDao.getAll();
       session.commit();
       return frightRecords; 
	}  




}  