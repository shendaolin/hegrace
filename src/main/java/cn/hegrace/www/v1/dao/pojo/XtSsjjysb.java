package cn.hegrace.www.v1.dao.pojo;

public class XtSsjjysb extends BaseDao{
    private String ssjjyid;

    private String sbid;

    private Integer zt;

    public String getSsjjyid() {
        return ssjjyid;
    }

    public void setSsjjyid(String ssjjyid) {
        this.ssjjyid = ssjjyid == null ? null : ssjjyid.trim();
    }

    public String getSbid() {
        return sbid;
    }

    public void setSbid(String sbid) {
        this.sbid = sbid == null ? null : sbid.trim();
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }
}