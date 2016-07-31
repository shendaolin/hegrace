package cn.hegrace.www.v1.seach;

public class Page {
	protected int page;
	protected int rp;
	protected String sortname;
	protected String sortorder;
	protected String query;
	protected String qtype;

	public String getOrderByClause(){
		return this.getSortname() + " " + this.getSortorder(); 
	}
	
	public int getStartPage(){
		return (getPage() - 1) * getRp();
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRp() {
		return rp;
	}

	public void setRp(int rp) {
		this.rp = rp;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

}
