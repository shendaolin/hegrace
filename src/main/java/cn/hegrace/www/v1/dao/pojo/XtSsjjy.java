package cn.hegrace.www.v1.dao.pojo;

import java.util.Date;

import cn.hegrace.www.v1.annotation.PrimaryKey;

public class XtSsjjy extends BaseDao{
    private String id;

    private String ssid;

    private String ryid;

    private String gwid;

    private Integer zt;

    private String zb;

    private String openid;

    private Date cjsj;

    private Integer sg;

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

    public String getGwid() {
        return gwid;
    }

    public void setGwid(String gwid) {
        this.gwid = gwid == null ? null : gwid.trim();
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public String getZb() {
        return zb;
    }

    public void setZb(String zb) {
        this.zb = zb == null ? null : zb.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Date getCjsj() {
    	return new Date();
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Integer getSg() {
        return sg;
    }

    public void setSg(Integer sg) {
        this.sg = sg;
    }
}