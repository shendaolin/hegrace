package cn.hegrace.www.v1.seach;

import java.util.HashMap;
import java.util.Map;

public class Flexigrid {

	private int pages;
	private int page;
	private int total;
	private Object[] rows;
	private Map map;
	private Page pageObject;

	public Flexigrid(Page page) {
		this.pageObject = page;
	}

	public Map getMap() {
		if (map == null) {
			map = new HashMap();
			map.put("page", pageObject.getRp());
			map.put("startPage", pageObject.getStartPage());
			map.put("orderByClause", pageObject.getOrderByClause());
		}
		return map;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Object[] getRows() {
		return rows;
	}

	public void setRows(Object[] rows) {
		this.rows = rows;
	}

	public int getPage() {
		return this.pageObject.getPage();
	}

	public void setPage(int page) {
		this.page = page;
	}

}
