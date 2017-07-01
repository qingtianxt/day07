package com.itheima.c_dbUtils.g_curd;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Test;

public class ceshi {
	@Test
	public void f1(){
		CURDDemo d = new CURDDemo();
		System.out.println("«Î“¿¥Œ ‰»Î");
		Scanner sc= new Scanner(System.in);
		String a=sc.next();
		String b=sc.next();
		int i=0;
		try {
			i = d.insert(a,b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println(i);
		}
		
	}
}
