package cn.hegrace.www.v1.dao.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.hegrace.www.v1.annotation.PrimaryKey;

public class XtSsgl extends BaseDao{
    private String id;

    private String ssmc;

    private String ssdd;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  
    private Date sskssj;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  
    private Date ssjssj;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  
    private Date cjkssj;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  
    private Date cjjssj;

    private Integer zt;
    private String ztName;
    private Integer ssjjySum;
    private Integer cszglSum;
    private String ssjs;
    private String sslj;
    @PrimaryKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

	 

	public String getSslj() {
		return sslj;
	}

	public void setSslj(String sslj) {
		this.sslj = sslj;
	}

	 

	public String getZtName() {
		return ztName;
	}

	public void setZtName(String ztName) {
		this.ztName = ztName;
	}

	public Integer getSsjjySum() {
		return ssjjySum;
	}

	public void setSsjjySum(Integer ssjjySum) {
		this.ssjjySum = ssjjySum;
	}

	public Integer getCszglSum() {
		return cszglSum;
	}

	public void setCszglSum(Integer cszglSum) {
		this.cszglSum = cszglSum;
	}

	public String getSsjs() {
		return ssjs;
	}

	public void setSsjs(String ssjs) {
		this.ssjs = ssjs;
	}
    
}