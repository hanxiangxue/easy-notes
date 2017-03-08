package com.easynotes.core.query;

import com.easynotes.core.base.BaseQuery;
import com.easynotes.core.model.Record;

@SuppressWarnings("serial")
public class RecordQuery extends BaseQuery<Record> {
	private Integer dictionaryId;// 字典的id
	private String entry;// 模糊匹配，进行entry的查询

	public Integer getDictionaryId() {
		return dictionaryId;
	}

	public void setDictionaryId(Integer dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

}
