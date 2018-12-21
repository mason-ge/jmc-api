package com.jmc.api.common;

/**
 * @Description:分页类
 * @Author: mason_ge
 * @Date: 17:05 2018/12/17
 */
public class Page {
	// 总记录数
	private int totalRows;
	// 总页数
	private int totalPages;
	// 每页显示记录数
	private int pageSize = Constants.PAGE_SIZE;
	// 当前页数
	private int pageNo = 1;

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		this.totalPages = totalRows / pageSize;
		int mod = totalRows % pageSize;
		if (mod > 0) {
			totalPages++;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
