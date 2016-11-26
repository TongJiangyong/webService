package com.realsil.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class A_GetSqlSessionFactory
{
	private static SqlSessionFactory sqlSessionFactory = null;
	
	private static A_GetSqlSessionFactory getSqlSessionFactory = null;

	private A_GetSqlSessionFactory()
	{
		String rs = "mybatis-config.xml";
		Reader reader = null;
		try
		{
			reader = Resources.getResourceAsReader(rs);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static A_GetSqlSessionFactory getInstance()
	{
		if (getSqlSessionFactory == null)
			getSqlSessionFactory = new A_GetSqlSessionFactory();
		return getSqlSessionFactory;
	}

	public static SqlSessionFactory getSqlSessionFactory()
	{
		return sqlSessionFactory;
	}

}
