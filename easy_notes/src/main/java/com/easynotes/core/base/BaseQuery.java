package com.easynotes.core.base;

import java.io.Serializable;

import com.easynotes.core.constant.Constant;

/**
 * 基本的查询类
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class BaseQuery<T> implements Serializable{

	private Integer pageNumber=Constant.DEFAULT_PAGE_NUMBER;// 记录的页码
	private Integer rows=Constant.DEFAULT_ROWS;// 行数

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

}
