package cn.hegrace.www.v1.dao.pojo;

import cn.hegrace.www.v1.annotation.PrimaryKey;

public class XtBsysb extends BaseDao{
    private String id;

    private String sblx;

    private String sbbh;

    private Integer sbzt;

	@PrimaryKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSblx() {
        return sblx;
    }

    public void setSblx(String sblx) {
        this.sblx = sblx == null ? null : sblx.trim();
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