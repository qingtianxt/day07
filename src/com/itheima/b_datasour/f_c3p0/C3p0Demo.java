package com.itheima.b_datasour.f_c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.itheima.utils.JdbcUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Demo {
	@Test
	//Ӳ����
	public void f1() throws Exception{
		ComboPooledDataSource ds =new ComboPooledDataSource();
		
		//���û�������
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql:///day07");
		ds.setUser("root");
		ds.setPassword("121203");
		
		Connection conn= ds.getConnection();
		String sql="insert into category values(?,?)";
		PreparedStatement st= conn.prepareStatement(sql);
		
		//���ò���
		st.setString(1, "c013");
		st.setString(2, "��ҩ");
		
		int i=st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResouse(conn, st, null);
	}
	@Test
	public void f2() throws Exception{
		//ComboPooledDataSource ds =new ComboPooledDataSource();
		ComboPooledDataSource ds=new ComboPooledDataSource("itcast123");
		Connection conn= ds.getConnection();
		String sql="insert into category values(?,?)";
		PreparedStatement st= conn.prepareStatement(sql);
		
		//���ò���
		st.setString(1, "c0124");
		st.setString(2, "��ҩ");
		
		int i=st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResouse(conn, st, null);
	}
}
