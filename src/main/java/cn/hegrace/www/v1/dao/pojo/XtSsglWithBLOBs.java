package cn.hegrace.www.v1.dao.pojo;

public class XtSsglWithBLOBs extends XtSsgl {
    private String ssjs;

    private String sslj;

    public String getSsjs() {
        return ssjs;
    }

    public void setSsjs(String ssjs) {
        this.ssjs = ssjs == null ? null : ssjs.trim();
    }

    public String getSslj() {
        return sslj;
    }

    public void setSslj(String sslj) {
        this.sslj = sslj == null ? null : sslj.trim();
    }
}