package cn.hegrace.www.v1.dao.pojo;

import cn.hegrace.www.v1.annotation.PrimaryKey;

public class XtCszgl extends BaseDao{
    private String id;

    private String ssid;

    private String xm;

    private Integer xb;

    private String zjlx;

    private String zjhm;

    private String dh;

    private String bh;

    private Integer gfx;
    
    private String xbName;
    
    private String gfxName;
    
    @PrimaryKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid == null ? null : ssid.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public Integer getXb() {
        return xb;
    }

    public void setXb(Integer xb) {
        this.xb = xb;
    }

    public String getZjlx() {
        return zjlx;
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx == null ? null : zjlx.trim();
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm == null ? null : zjhm.trim();
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh == null ? null : dh.trim();
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh == null ? null : bh.trim();
    }

    public Integer getGfx() {
        return gfx;
    }

    public void setGfx(Integer gfx) {
        this.gfx = gfx;
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