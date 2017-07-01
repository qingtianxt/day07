package com.itheima.b_datasour.b_my;
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
			try {
				Connection conn=JdbcUtils.getConnection();
				pool.addLast(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("从连接池中获取一个连接");
		return pool.removeFirst();
	}
	//归还连接的方法
	public static void addBack(Connection conn){
		//将conn放入到list的最后面即可
		pool.addLast(conn);
		System.out.println("连接已归还");
	}
}
