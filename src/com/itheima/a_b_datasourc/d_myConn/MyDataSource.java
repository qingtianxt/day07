package com.itheima.a_b_datasourc.d_myConn;
/**
 * 简易的连接池
 * @author wzw
 *
 */

import java.sql.Connection;
import java.util.LinkedList;

import com.itheima.utils.JdbcUtils;

public class MyDataSource {
	static LinkedList<Connection> pool=new LinkedList<>();
	static {
		for(int i=0;i<3;i++)
		{
			try {
				Connection conn = JdbcUtils.getConnection();
				pool.addLast(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//从连接池中获取
	public static Connection getConnection(){
		//判断连接池是否为空
		for(int i=0;i<3;i++){
			//再添加两个进去
			if(pool.isEmpty())
			{
				try {
					Connection conn=JdbcUtils.getConnection();
					pool.addLast(conn);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("从连接池中获取一个连接");
		Connection conn= pool.removeFirst();
		//将conn进行包装
		ConnectionWarp myConn=new ConnectionWarp(conn,pool);
		return myConn;
	}
	//归还连接的方法
	public static void addBack(Connection conn){
		//将conn放入到list的最后面即可
		pool.addLast(conn);
		System.out.println("连接已归还");
	}
}
