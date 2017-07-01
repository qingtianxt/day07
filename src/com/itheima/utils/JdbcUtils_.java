package com.itheima.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//�ĵ�ע�ͺô��������ڵ��õķ�������ʱ������ע��

public class JdbcUtils_ {
	
	//��ȡ����
	public static Connection getConnection() throws Exception{
		//ע������
		Class.forName("com.mysql.jdbc.Driver");
		
		//��ȡ���� �����
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/day07","root","121203");
		return conn;
	}
	//�ͷ���Դ
	public static void closeResouse(Connection conn,Statement st,ResultSet rs)
	{
		closeResultSet(rs);
		closeStatement(st);
		closeConn(conn);
	}
	/**
	 * �ͷ�����
	 * @param conn ����
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
	 * �ͷ�����
	 * @param st ����
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
	 * �ͷ�����
	 * param rs����� ����
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
