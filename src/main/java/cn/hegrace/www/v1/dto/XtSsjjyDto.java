package cn.hegrace.www.v1.dto;

import cn.hegrace.www.v1.dao.pojo.XtSsjjy;

public class XtSsjjyDto extends XtSsjjy {

	private String xm;
	private String dh;
	private String sbid;
	private String jlid;

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getDh() {
		return dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	public String getSbid() {
		return sbid;
	}

	public void setSbid(String sbid) {
		this.sbid = sbid;
	}

	public String getJlid() {
		return jlid;
	}

	public void setJlid(String jlid) {
		this.jlid = jlid;
	}

}