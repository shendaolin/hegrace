package cn.hegrace.www.v1.dto;

import cn.hegrace.www.v1.dao.pojo.XtSsgl;

public class XtSsglDto extends XtSsgl {
	private int cszcount;
	private int jjycount;

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
