package cn.hegrace.www.v1.dao.pojo;

import java.util.Date;

public class XtCzyh {
    private Long id;

    private String dlm;

    private String dlmm;

    private String xm;

    private String dh;

    private Long zw;

    private Long ss;

    private Date cjrq;

    private Long crj;

    private Date xgrq;

    private Long xgr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDlm() {
        return dlm;
    }

    public void setDlm(String dlm) {
        this.dlm = dlm == null ? null : dlm.trim();
    }

    public String getDlmm() {
        return dlmm;
    }

    public void setDlmm(String dlmm) {
        this.dlmm = dlmm == null ? null : dlmm.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh == null ? null : dh.trim();
    }

    public Long getZw() {
        return zw;
    }

    public void setZw(Long zw) {
        this.zw = zw;
    }

    public Long getSs() {
        return ss;
    }

    public void setSs(Long ss) {
        this.ss = ss;
    }

    public Date getCjrq() {
        return cjrq;
    }

    public void setCjrq(Date cjrq) {
        this.cjrq = cjrq;
    }

    public Long getCrj() {
        return crj;
    }

    public void setCrj(Long crj) {
        this.crj = crj;
    }

    public Date getXgrq() {
        return xgrq;
    }

    public void setXgrq(Date xgrq) {
        this.xgrq = xgrq;
    }

    public Long getXgr() {
        return xgr;
    }

    public void setXgr(Long xgr) {
        this.xgr = xgr;
    }
}