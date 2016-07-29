package cn.hegrace.www.v1.dao.pojo;

public class XtGydm {
    private Long id;

    private Integer lbid;

    private String dmmc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLbid() {
        return lbid;
    }

    public void setLbid(Integer lbid) {
        this.lbid = lbid;
    }

    public String getDmmc() {
        return dmmc;
    }

    public void setDmmc(String dmmc) {
        this.dmmc = dmmc == null ? null : dmmc.trim();
    }
}