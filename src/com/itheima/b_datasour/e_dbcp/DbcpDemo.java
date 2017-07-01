package com.itheima.b_datasour.e_dbcp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import com.itheima.utils.JdbcUtils;

public class DbcpDemo {
	@Test
	//Ӳ����
	public void f1() throws Exception{
		
		//�������ӳ�
		BasicDataSource ds=new BasicDataSource();
		
		//������Ϣ
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql:///day07");
		ds.setUsername("root");
		ds.setPassword("121203");
		
		
		Connection conn= ds.getConnection();
		String sql="insert into category values(?,?)";
		PreparedStatement st= conn.prepareStatement(sql);
		
		//���ò���
		st.setString(1, "c011");
		st.setString(2, "����");
		
		int i=st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResouse(conn, st, null);
	}
	
	@Test
	public void f2() throws Exception, IOException{
		//��������ļ�
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/dbcp.properties"));
		
		
		//�������ӳ�
		DataSource ds=new BasicDataSourceFactory().createDataSource(prop);
		Connection conn= ds.getConnection();
		String sql="insert into category values(?,?)";
		PreparedStatement st= conn.prepareStatement(sql);
		
		//���ò���
		st.setString(1, "c012");
		st.setString(2, "����1");
		
		int i=st.executeUpdate();
		System.out.println(i);
		JdbcUtils.closeResouse(conn, st, null);
	}
}
