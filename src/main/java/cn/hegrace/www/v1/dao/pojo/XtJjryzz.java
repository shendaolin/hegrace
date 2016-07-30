package cn.hegrace.www.v1.dao.pojo;

public class XtJjryzz {
    private Long ryid;

    private String tpdz;

    public Long getRyid() {
        return ryid;
    }

    public void setRyid(Long ryid) {
        this.ryid = ryid;
    }

    public String getTpdz() {
        return tpdz;
    }

    public void setTpdz(String tpdz) {
        this.tpdz = tpdz == null ? null : tpdz.trim();
    }
}