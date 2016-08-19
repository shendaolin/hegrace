package cn.hegrace.www.v1.dto;

import cn.hegrace.www.v1.dao.pojo.XtSsgw;

public class XtSsgwDto extends XtSsgw {

	private String id;
	private String gwmc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGwmc() {
		return gwmc;
	}
	public void setGwmc(String gwmc) {
		this.gwmc = gwmc;
	}
	
}
