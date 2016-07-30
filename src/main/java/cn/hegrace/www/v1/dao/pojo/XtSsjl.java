package cn.hegrace.www.v1.dao.pojo;

public class XtSsjl {
    private Long id;

    private Long ryid;

    private Long qjid;

    private Integer zt;

    private String bhms;

    private String clms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRyid() {
        return ryid;
    }

    public void setRyid(Long ryid) {
        this.ryid = ryid;
    }

    public Long getQjid() {
        return qjid;
    }

    public void setQjid(Long qjid) {
        this.qjid = qjid;
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