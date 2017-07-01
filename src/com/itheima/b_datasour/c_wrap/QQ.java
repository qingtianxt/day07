package com.itheima.b_datasour.c_wrap;

public class QQ implements Car {

	@Override
	public void run() {
		System.out.println("qq在跑");
	}

	@Override
	public void stop() {
		System.out.println("刹得住车");
	}

}
