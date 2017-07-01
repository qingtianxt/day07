package com.itheima.utils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	//获取数据源
	private  static ComboPooledDataSource ds=new ComboPooledDataSource();
	
	/**
	 * 获取数据源
	 * @return
	 */
	public static DataSource getDataSource(){
		return ds;
	}
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	//释放资源
	/**
	 * 释放链接
	 * @param conn 连接
	 * */
	public static void closeConn(Connection conn)
	{
		if(conn!=null)
		{
			try{
				conn.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			conn=null;
		}
	}
	/**
	 * 释放链接
	 * @param st 连接
	 * */
	public static void closeStatement(Statement st)
	{
		if(st!=null)
		{
			try{
				st.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			st=null;
		}
	}
	/**
	 * 释放链接
	 * param rs结果集 连接
	 * */
	public static void closeResultSet(ResultSet rs)
	{
		if(rs!=null)
		{
			try{
				rs.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			rs=null;
		}
	}
	
}
