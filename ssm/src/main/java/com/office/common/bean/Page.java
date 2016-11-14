package com.office.common.bean;

public class Page {

	private Integer pageNo;

	private Integer pageSize;

	private Integer totalPage;
	
	public Page() {}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Page(Integer pageNo, Integer totalPage) {
		this.pageNo = pageNo;
		this.totalPage = totalPage;
	}
	
	public Page(Integer pageNo, Integer pageSize, Integer totalPage) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
	}
}
