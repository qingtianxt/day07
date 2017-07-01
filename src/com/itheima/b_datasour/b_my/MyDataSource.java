package com.itheima.b_datasour.b_my;
/**
 * ���׵����ӳ�
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
	//�����ӳ��л�ȡ
	public static Connection getConnection(){
		//�ж����ӳ��Ƿ�Ϊ��
		for(int i=0;i<3;i++){
			//�����������ȥ
			try {
				Connection conn=JdbcUtils.getConnection();
				pool.addLast(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("�����ӳ��л�ȡһ������");
		return pool.removeFirst();
	}
	//�黹���ӵķ���
	public static void addBack(Connection conn){
		//��conn���뵽list������漴��
		pool.addLast(conn);
		System.out.println("�����ѹ黹");
	}
}
