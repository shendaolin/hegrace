package cn.hegrace.www.v1.dao.pojo;

import cn.hegrace.www.v1.annotation.PrimaryKey;

public class XtSsjjysb extends BaseDao{
    private String id;

    private String ssjjyid;

    private String sbid;

    private Integer zt;

    @PrimaryKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

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