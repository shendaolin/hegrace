package cn.hegrace.www.v1.dao.pojo;

import java.util.Date;

import cn.hegrace.www.v1.annotation.PrimaryKey;

public class XtYjfk extends BaseDao{
    private String id;

    private Date fkrq;

    private String xm;

    private String dh;

    private Integer zt;

    private String fknr;
    
    private String ztName;
    
    @PrimaryKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getFkrq() {
        return fkrq;
    }

    public void setFkrq(Date fkrq) {
        this.fkrq = fkrq;
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

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public String getFknr() {
        return fknr;
    }

    public void setFknr(String fknr) {
        this.fknr = fknr == null ? null : fknr.trim();
    }

	public String getZtName() {
		return ztName;
	}

	public void setZtName(String ztName) {
		this.ztName = ztName;
	}
    
}