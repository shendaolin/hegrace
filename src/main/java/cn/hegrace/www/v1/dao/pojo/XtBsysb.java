package cn.hegrace.www.v1.dao.pojo;

public class XtBsysb {
    private Integer id;

    private Long sblx;

    private String sbbh;

    private Integer sbzt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSblx() {
        return sblx;
    }

    public void setSblx(Long sblx) {
        this.sblx = sblx;
    }

    public String getSbbh() {
        return sbbh;
    }

    public void setSbbh(String sbbh) {
        this.sbbh = sbbh == null ? null : sbbh.trim();
    }

    public Integer getSbzt() {
        return sbzt;
    }

    public void setSbzt(Integer sbzt) {
        this.sbzt = sbzt;
    }
}