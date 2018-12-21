package com.jmc.api.common;

/**
 * @Description: 接口返回对象
 * @Author: mason_ge
 * @Date: 17:56 2018/12/17
 */
public class ReturnObj {
	// 返回的数据
	private Object data;
	// 返回的code
	private int code;
	// 返回的信息
	private String mes;
	// 返回的分页信息
	private Object page;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Object getPage() {
		return page;
	}

	public void setPage(Object page) {
		this.page = page;
	}
}
