package com.itheima.b_datasour.b_my;

import java.sql.Connection;

public class TestDs {
	public static void main(String[]args)
	{
		//�������ӳ�
		MyDataSource ds = new MyDataSource();
		
		//��ȡ����
		Connection conn = ds.getConnection();
		System.out.println(conn);
		
		//�黹����
		ds.addBack(conn);
	}
}
