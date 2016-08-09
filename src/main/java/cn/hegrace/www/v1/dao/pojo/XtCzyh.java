package cn.hegrace.www.v1.dao.pojo;

import cn.hegrace.www.v1.annotation.PrimaryKey;

public class XtCzyh extends BaseDao{
    private String id;

    private String dlm;

    private String dlmm;

    private String xm;

    private String dh;

    private String zw;

    private String ssid;
    
    private String zwName;
    @PrimaryKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDlm() {
        return dlm;
    }

    public void setDlm(String dlm) {
        this.dlm = dlm == null ? null : dlm.trim();
    }

    public String getDlmm() {
        return dlmm;
    }

    public void setDlmm(String dlmm) {
        this.dlmm = dlmm == null ? null : dlmm.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh == null ? null : dh.trim();
    }

    public String getZw() {
        return zw;
    }

    public void setZw(String zw) {
        this.zw = zw == null ? null : zw.trim();
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid == null ? null : ssid.trim();
    }

	public String getZwName() {
		return zwName;
	}

	public void setZwName(String zwName) {
		this.zwName = zwName;
	}
    
}