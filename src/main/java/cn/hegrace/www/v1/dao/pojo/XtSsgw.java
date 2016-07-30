package cn.hegrace.www.v1.dao.pojo;

public class XtSsgw {
    private Long id;

    private Long ssid;

    private String gwmc;

    private Integer gwsl;

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