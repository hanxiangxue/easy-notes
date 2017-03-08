package com.easynotes.core.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.easynotes.core.base.exception.ParamException;
import com.easynotes.core.constant.Constant;

public class BaseController {
	/**
	 * 设置ctx参数为项目的上下文路径
	 * @param model
	 * @param request
	 */
	@ModelAttribute
	public void addModelAttributers(Model model, HttpServletRequest request) {
		model.addAttribute("ctx", request.getContextPath());
	}
	/**
	 * 默认成功
	 * @return
	 */
	public ResultInfo success(){
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultCode(Constant.SUCCESS_CODE);
		resultInfo.setResultMessage(Constant.SUCCESS_MESSAGE);
		return resultInfo;
	}
	/**
	 *传入result作为结果进行返回
	 * @param result
	 * @return
	 */
	public ResultInfo success(Object result){
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultCode(Constant.SUCCESS_CODE);
		resultInfo.setResultMessage(Constant.SUCCESS_MESSAGE);

		resultInfo.setResult(result);
		return resultInfo;	
	}
	/**
	 * 传入指定的成功信息及结果值，进行返回
	 * @param resultMessage
	 * @param result
	 * @return
	 */
	public ResultInfo success(String resultMessage,Object result){
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultCode(Constant.SUCCESS_CODE);
		resultInfo.setResultMessage(resultMessage);
		resultInfo.setResult(result);
		return resultInfo;	
	}
	/**
	 * 返回默认的错误信息与错误码
	 * @return
	 */
	public ResultInfo failure(){
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultCode(Constant.FAILUER_CODE);
		resultInfo.setResultMessage(Constant.FAILUER_MESSAGE);
		return resultInfo;
	}
	/**
	 * 返回指定的错误信息与默认的错误码
	 * @param resultMessage错误信息
	 * @return
	 */
	public ResultInfo failure(String resultMessage){
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultCode(Constant.FAILUER_CODE);
		resultInfo.setResultMessage(resultMessage);
		return resultInfo;
	}
	/**
	 * 返回指定的错误信息与错误码
	 * @param resultMessage错误信息
	 * @param resultCode错误码
	 * @return
	 */
	public ResultInfo failure(String resultMessage,Integer resultCode){
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultCode(resultCode);
		resultInfo.setResultMessage(resultMessage);
		return resultInfo;
	}
	/**
	 * 返回对应的paramException的错误信息与错误码
	 * @param exception
	 * @return
	 */
	public ResultInfo failure(ParamException exception){
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultCode(exception.getCode());
		resultInfo.setResultMessage(exception.getErrMessage());
		return resultInfo;
	}
	
	
}
