package com.itheima.c_dbUtils.g_curd;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.itheima.utils.DataSourceUtils;

public class CURDDemo {
	@Test
	public int insert(String a,String b) throws SQLException{
		//1.����queryrunner��
		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		//2.��дsql
		String sql="insert into category values(?,?)";
		
		//3ִ��sql
		int i=qr.update(sql,a,b);
		return i;
	}
	@Test
	public void update() throws SQLException{
		QueryRunner qr= new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="update category set cname=? where cid=?";
		qr.update(sql,"x����","c000");
	}
}
