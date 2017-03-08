package com.easynotes.core.base.exception;

import com.easynotes.core.constant.Constant;

/**
 * 参数异常类
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class ParamException extends RuntimeException {
	private Integer code = Constant.FAILUER_CODE;//错误码
	private String errMessage;//错误信息

	public ParamException() {
		super();
	}

	public ParamException(String message) {
		super(message);
		this.setErrMessage(message);
	}

	public ParamException(String message, Integer code) {
		super(message);
		this.setErrMessage(message);
		this.setCode(code);
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
