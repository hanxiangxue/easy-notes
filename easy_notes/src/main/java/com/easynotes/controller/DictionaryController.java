package com.easynotes.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easynotes.core.base.BaseController;
import com.easynotes.core.base.ResultInfo;
import com.easynotes.core.base.exception.ParamException;
import com.easynotes.core.constant.Constant;
import com.easynotes.core.model.Dictionary;
import com.easynotes.core.query.DictionaryQuery;
import com.easynotes.core.util.LoginUserUtil;
import com.easynotes.core.vo.DictionaryVo;
import com.easynotes.service.DictionaryService;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController extends BaseController {
	@Resource
	private DictionaryService dictionaryService;

	/**
	 * 增加或者更新数据
	 * @param dictionaryVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addOrUpdate")
	public ResultInfo addOrUpdate(Dictionary dictionary,HttpServletRequest request) {
		ResultInfo resultInfo = null;
		Integer userId=LoginUserUtil.releaseUserIdFromCookie(request);
		try {
			dictionaryService.addOrUpdate(dictionary,userId);
			resultInfo = success();
		} catch (ParamException e) {
			resultInfo = failure(e);
		}
		return resultInfo;
	}

	/**
	 * 删除数据
	 * @param id 字典id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delete")
	public ResultInfo delete(Integer id) {
		ResultInfo resultInfo = null;
		try {
			Integer result = dictionaryService.deleteByID(id);
			if (null == result || result < 1) {
				resultInfo = failure(Constant.FAILUER_MESSAGE);
			} else {
				resultInfo = success();
			}

		} catch (ParamException e) {
			resultInfo = failure(e);
		}
		return resultInfo;
	}

	/**
	 * 批量删除数据
	 * @param ids 字典id组成的数组
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteBatch")
	public ResultInfo deleteBatch(Integer[] ids) {
		ResultInfo resultInfo = null;
		try {
			Integer result = dictionaryService.deleteBatch(ids);
			if (null == result || result < 1) {
				resultInfo = failure(Constant.FAILUER_MESSAGE);
			} else {
				resultInfo = success();
			}
		} catch (ParamException e) {
			resultInfo = failure(e);
		}
		return resultInfo;
	}

	/**
	 * 字典查询
	 * @param query :DictionaryQuery
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryForPages")
	public ResultInfo queryForPages(DictionaryQuery query) {
		ResultInfo resultInfo = null;
		try {
			List<DictionaryVo> list = dictionaryService.queryVoForList(query);
			resultInfo = success(list);
		} catch (ParamException e) {
			resultInfo = failure(e);
		}
		return resultInfo;
	}

}
