package com.easynotes.core.vo;

import com.easynotes.core.base.BaseVo;
import com.easynotes.core.model.Record;

@SuppressWarnings("serial")
public class RecordVo extends BaseVo<Record> {
	private String entry;// 词条
	private String paraphrase;// 对应的解释

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getParaphrase() {
		return paraphrase;
	}

	public void setParaphrase(String paraphrase) {
		this.paraphrase = paraphrase;
	}

	@Override
	public String toString() {
		return "RecordVo [entry=" + entry + ", paraphrase=" + paraphrase + "]";
	}

}
