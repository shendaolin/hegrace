package cn.hegrace.www.v1.dao.pojo;

public class XtDmlb {
    private Integer lbid;

    private String lbmc;

    public Integer getLbid() {
        return lbid;
    }

    public void setLbid(Integer lbid) {
        this.lbid = lbid;
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc == null ? null : lbmc.trim();
    }
}