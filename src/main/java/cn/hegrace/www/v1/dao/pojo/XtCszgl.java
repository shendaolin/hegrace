package cn.hegrace.www.v1.dao.pojo;

public class XtCszgl {
    private Long id;

    private Long ssid;

    private String xm;

    private Integer xb;

    private Long zjlx;

    private String zjhm;

    private String dh;

    private String bh;

    private Integer gfx;

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

    public Long getZjlx() {
        return zjlx;
    }

    public void setZjlx(Long zjlx) {
        this.zjlx = zjlx;
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
}