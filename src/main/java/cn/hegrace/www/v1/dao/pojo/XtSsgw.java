package cn.hegrace.www.v1.dao.pojo;

import java.util.Date;

import cn.hegrace.www.v1.annotation.PrimaryKey;

public class XtSsgw extends BaseDao{
    private String id;

    private String ssid;

    private String gwmc;

    private Integer gwsl;

    private String dw;

    private String img;

    private Date cjsj;

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

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw == null ? null : dw.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Date getCjsj() {
        return new Date();
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }
}