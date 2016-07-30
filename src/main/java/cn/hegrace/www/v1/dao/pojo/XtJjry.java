package cn.hegrace.www.v1.dao.pojo;

public class XtJjry {
    private Integer id;

    private String xm;

    private Integer xb;

    private Long zjlx;

    private String zjhm;

    private String dh;

    private Long sflx;

    private String lb;

    private Integer zt;

    private String fzcc;

    private Integer ly;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Long getSflx() {
        return sflx;
    }

    public void setSflx(Long sflx) {
        this.sflx = sflx;
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
}