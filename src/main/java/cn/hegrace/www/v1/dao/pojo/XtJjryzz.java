package cn.hegrace.www.v1.dao.pojo;

public class XtJjryzz extends BaseDao{
    private String ryid;

    private String tpdz;

    public String getRyid() {
        return ryid;
    }

    public void setRyid(String ryid) {
        this.ryid = ryid == null ? null : ryid.trim();
    }

    public String getTpdz() {
        return tpdz;
    }

    public void setTpdz(String tpdz) {
        this.tpdz = tpdz == null ? null : tpdz.trim();
    }
}