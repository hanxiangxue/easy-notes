package com.easynotes.core.query;

import com.easynotes.core.base.BaseQuery;
import com.easynotes.core.model.Dictionary;

@SuppressWarnings("serial")
public class DictionaryQuery extends BaseQuery<Dictionary> {
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
