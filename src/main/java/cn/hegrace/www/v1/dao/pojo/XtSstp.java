package cn.hegrace.www.v1.dao.pojo;

public class XtSstp extends BaseDao{
    private String ssid;

    private String tpdz;

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid == null ? null : ssid.trim();
    }

    public String getTpdz() {
        return tpdz;
    }

    public void setTpdz(String tpdz) {
        this.tpdz = tpdz == null ? null : tpdz.trim();
    }
}