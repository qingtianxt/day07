package com.itheima.a_b_datasourc.d_myConn;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDs {
	public static void main(String[]args) throws SQLException
	{
		//�������ӳ�
		MyDataSource ds = new MyDataSource();
		
		//��ȡ����
		Connection conn = ds.getConnection();
		System.out.println(conn);
		
		//�黹����
		conn.close();
	}
}
