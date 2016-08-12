package cn.hegrace.www.v1.dao.pojo;

import cn.hegrace.www.v1.annotation.PrimaryKey;

public class XtSsjl extends BaseDao{
    private String id;

    private String ssid;

    private String ryid;

    private String qjid;

    private Integer zt;

    private String bhms;

    private String clms;

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

    public String getRyid() {
        return ryid;
    }

    public void setRyid(String ryid) {
        this.ryid = ryid == null ? null : ryid.trim();
    }

    public String getQjid() {
        return qjid;
    }

    public void setQjid(String qjid) {
        this.qjid = qjid == null ? null : qjid.trim();
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public String getBhms() {
        return bhms;
    }

    public void setBhms(String bhms) {
        this.bhms = bhms == null ? null : bhms.trim();
    }

    public String getClms() {
        return clms;
    }

    public void setClms(String clms) {
        this.clms = clms == null ? null : clms.trim();
    }
}