package cn.hegrace.www.v1.dao.pojo;

import cn.hegrace.www.v1.annotation.PrimaryKey;

public class XtJjry extends BaseDao{
    private String id;

    private String xm;

    private Integer xb;

    private String zjlx;

    private String zjhm;

    private String dh;

    private String sflx;

    private String lb;

    private Integer zt;

    private String fzcc;

    private Integer ly;
    
    private String xbName;
    private String lyName;
    private String ztName;
    private String sflxName;
    private String zjlxName;
    @PrimaryKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getSflx() {
        return sflx;
    }

    public void setSflx(String sflx) {
        this.sflx = sflx == null ? null : sflx.trim();
    }

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb == null ? null : lb.trim();
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public String getFzcc() {
        return fzcc;
    }

    public void setFzcc(String fzcc) {
        this.fzcc = fzcc == null ? null : fzcc.trim();
    }

    public Integer getLy() {
        return ly;
    }

    public void setLy(Integer ly) {
        this.ly = ly;
    }

	public String getXbName() {
		return xbName;
	}

	public void setXbName(String xbName) {
		this.xbName = xbName;
	}

	public String getLyName() {
		return lyName;
	}

	public void setLyName(String lyName) {
		this.lyName = lyName;
	}

	public String getZtName() {
		return ztName;
	}

	public void setZtName(String ztName) {
		this.ztName = ztName;
	}

	public String getSflxName() {
		return sflxName;
	}

	public void setSflxName(String sflxName) {
		this.sflxName = sflxName;
	}

	public String getZjlxName() {
		return zjlxName;
	}

	public void setZjlxName(String zjlxName) {
		this.zjlxName = zjlxName;
	}
    
}