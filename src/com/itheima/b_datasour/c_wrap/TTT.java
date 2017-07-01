package com.itheima.b_datasour.c_wrap;

public class TTT {
	public static void main(String[]args)
	{
		QQ qq= new QQ();
//		qq.run();
//		qq.stop();
		CarWarp car = new CarWarp(qq);
		car.run();
		car.stop();
	}
}
