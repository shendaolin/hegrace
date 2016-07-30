package cn.hegrace.www.v1.dao.pojo;

public class XtSsjjy {
    private Long id;

    private Long ssid;

    private Long ryid;

    private Long gwid;

    private Integer zt;

    private String zb;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSsid() {
        return ssid;
    }

    public void setSsid(Long ssid) {
        this.ssid = ssid;
    }

    public Long getRyid() {
        return ryid;
    }

    public void setRyid(Long ryid) {
        this.ryid = ryid;
    }

    public Long getGwid() {
        return gwid;
    }

    public void setGwid(Long gwid) {
        this.gwid = gwid;
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
}