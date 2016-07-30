package cn.hegrace.www.v1.dao.pojo;

import java.util.Date;

public class XtSsgl {
    private Long id;

    private String ssmc;

    private String ssdd;

    private Date sskssj;

    private Date ssjssj;

    private Date cjkssj;

    private Date cjjssj;

    private Integer zt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsmc() {
        return ssmc;
    }

    public void setSsmc(String ssmc) {
        this.ssmc = ssmc == null ? null : ssmc.trim();
    }

    public String getSsdd() {
        return ssdd;
    }

    public void setSsdd(String ssdd) {
        this.ssdd = ssdd == null ? null : ssdd.trim();
    }

    public Date getSskssj() {
        return sskssj;
    }

    public void setSskssj(Date sskssj) {
        this.sskssj = sskssj;
    }

    public Date getSsjssj() {
        return ssjssj;
    }

    public void setSsjssj(Date ssjssj) {
        this.ssjssj = ssjssj;
    }

    public Date getCjkssj() {
        return cjkssj;
    }

    public void setCjkssj(Date cjkssj) {
        this.cjkssj = cjkssj;
    }

    public Date getCjjssj() {
        return cjjssj;
    }

    public void setCjjssj(Date cjjssj) {
        this.cjjssj = cjjssj;
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }
}