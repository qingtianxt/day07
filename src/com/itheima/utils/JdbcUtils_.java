package com.itheima.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//文档注释好处：可以在调用的方法出现时所做的注释

public class JdbcUtils_ {
	
	//获取连接
	public static Connection getConnection() throws Exception{
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//获取连接 整理包
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/day07","root","121203");
		return conn;
	}
	//释放资源
	public static void closeResouse(Connection conn,Statement st,ResultSet rs)
	{
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}
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
