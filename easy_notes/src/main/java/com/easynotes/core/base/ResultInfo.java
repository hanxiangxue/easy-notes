package com.easynotes.core.base;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResultInfo implements Serializable{
	private Integer resultCode;//结果状态码
	private String resultMessage;//结果消息
	private Object result;//结果携带的数据

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
