package cn.hegrace.www.v1.dto;

import cn.hegrace.www.v1.dao.pojo.XtCszgl;

public class XtCszglDto extends XtCszgl {

	private String sbid;
	private String jlid;
	private String xbName;
	private String gfxName;

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

	public String getXbName() {
		return xbName;
	}

	public void setXbName(String xbName) {
		this.xbName = xbName;
	}

	public String getGfxName() {
		return gfxName;
	}

	public void setGfxName(String gfxName) {
		this.gfxName = gfxName;
	}

}
