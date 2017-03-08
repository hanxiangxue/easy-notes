package com.easynotes.core.util;

import org.apache.commons.lang3.StringUtils;

import com.easynotes.core.base.exception.ParamException;

public class AssertUtil {
	
	public static void isTrue(Boolean flag,String msg){
		// 判断操作是否成功
		if(flag){
			throw new ParamException(msg);
		}
	}
	
	public static void isEmpty(String str,String msg){
		isTrue(StringUtils.isEmpty(str),msg);
	}

}
