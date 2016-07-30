package cn.hegrace.www.v1.dao.pojo;

public class XtSstp {
    private Long ssid;

    private String tpdz;

    public Long getSsid() {
        return ssid;
    }

    public void setSsid(Long ssid) {
        this.ssid = ssid;
    }

    public String getTpdz() {
        return tpdz;
    }

    public void setTpdz(String tpdz) {
        this.tpdz = tpdz == null ? null : tpdz.trim();
    }
}