package cn.hegrace.www.v1.dto;

import cn.hegrace.www.v1.dao.pojo.XtSsgl;

public class XtSsglDto extends XtSsgl {
	private int cszcount;
	private int jjycount;
	private int num1; //赛事急救员人数
	private int num2;//赛事志愿者数量
	private int num3;//赛事突发情况数量
	private int num4;//赛事处理数量
	private int num5;//赛事处理数量取消
	
	public int getNum5() {
		return num5;
	}

	public void setNum5(int num5) {
		this.num5 = num5;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}

	public int getNum4() {
		return num4;
	}

	public void setNum4(int num4) {
		this.num4 = num4;
	}

	public int getCszcount() {
		return cszcount;
	}

	public void setCszcount(int cszcount) {
		this.cszcount = cszcount;
	}

	public int getJjycount() {
		return jjycount;
	}

	public void setJjycount(int jjycount) {
		this.jjycount = jjycount;
	}

}
