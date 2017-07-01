package com.itheima.a_jdbc.a_hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.itheima.utils.JdbcUtils;
import com.itheima.utils.JdbcUtils_;

public class Hello {
	@Test
	public void f1(){
		System.out.println("hello");
	}
	@Test
	public void f2() throws Exception{
		//ע������
		Class.forName("com.mysql.jdbc.Driver");
		//��ȡ����
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/day07","root","121203");
		//��дsql
		String sql="select * from category";
		//�������ִ����
		PreparedStatement st = conn.prepareStatement(sql);
		//���ò���
		
		//ִ��sql
		ResultSet rs = st.executeQuery();
		//������
		while(rs.next())
		{
			
			System.out.println(rs.getString("cid")+"::"+rs.getString("cname"));
		}
		//�ͷ���Դ
		rs.close();
		st.close();
		conn.close();
	}
	//����һ������
	@Test
	public void f3(){
		
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement st= null;
		
		
		try {
			//��ȡ����
			conn=JdbcUtils_.getConnection();
			//��дsql
			String sql="insert into category values(?,?)";
			//��ȡ���ִ����
			st=conn.prepareStatement(sql);
			//���ò���
			st.setString(1, "c006");
			st.setString(2, "����");
			
			//ִ��sql
			int i=st.executeUpdate();//executeUpdate�Ƕ����ݽ����޸ģ��޸ĵĽ������Ӱ�������
			
			//������
			if(i==1)
			{
				System.out.println("sucess");
			}
			else
			{
				System.out.println("fail");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//�ͷ���Դ
			JdbcUtils_.closeResouse(conn, st, rs);
		}
	}
	@Test
	public void f11(){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			conn=JdbcUtils.getConnection();
			String sql="update category set cname=? where cid=?";
			st=conn.prepareStatement(sql);
			st.setString(1, "�ֻ�");
			st.setString(2, "c006");
			
			int i=st.executeUpdate();
			
			if(i==1)
			{
				System.out.println("sucess");
			}
			else
			{
				System.out.println("false");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ͷ���Դ
		JdbcUtils.closeResouse(conn, st, rs);
		
	}
	@Test
	public void f12(){
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try{
			conn=JdbcUtils.getConnection();
			String sql="delete from category where cid=?";
			st=conn.prepareStatement(sql);
			st.setString(1, "c006");
			
			int i=st.executeUpdate();
			
			if(i==1)
			{
				System.out.println("sucess");
			}
			else
			{
				System.out.println("false");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�ͷ���Դ
		JdbcUtils.closeResouse(conn, st, rs);
	}
}
