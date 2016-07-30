package cn.hegrace.www.v1.dao.pojo;

import cn.hegrace.www.v1.annotation.PrimaryKey;

public class XtSsgw extends BaseDao{
    private String id;

    private String ssid;

    private String gwmc;

    private Integer gwsl;
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

    public String getGwmc() {
        return gwmc;
    }

    public void setGwmc(String gwmc) {
        this.gwmc = gwmc == null ? null : gwmc.trim();
    }

    public Integer getGwsl() {
        return gwsl;
    }

    public void setGwsl(Integer gwsl) {
        this.gwsl = gwsl;
    }
}