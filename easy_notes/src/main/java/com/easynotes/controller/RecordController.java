package com.easynotes.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easynotes.core.base.BaseController;
import com.easynotes.core.base.ResultInfo;
import com.easynotes.core.base.exception.ParamException;
import com.easynotes.core.constant.Constant;
import com.easynotes.core.model.Record;
import com.easynotes.core.query.RecordQuery;
import com.easynotes.core.vo.RecordVo;
import com.easynotes.service.RecordService;

/**
 * 记录的增删改查接口
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/record")
public class RecordController extends BaseController {
	@Resource
	private RecordService recordService;

	/**
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public ResultInfo addOrUpdate(Record record) {
		ResultInfo resultInfo = null;
		try {
			recordService.addOrUpdate(record);
			resultInfo = success();
		} catch (ParamException e) {
			resultInfo = this.failure(e);
		}
		return resultInfo;
	}

	/**
	 * 
	 * @param entry
	 * @param dictionaryId
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public ResultInfo delete(String entry, Integer dictionaryId) {
		ResultInfo resultInfo = null;
		try {
			recordService.delete(entry, dictionaryId);
			resultInfo = success();
		} catch (ParamException e) {
			resultInfo = this.failure(e);
		}
		return resultInfo;
	}

	/**
	 * 
	 * @param entries
	 * @param dictionaryId
	 * @return
	 */
	@RequestMapping("/deleteBatch")
	@ResponseBody
	public ResultInfo deleteBatch(String[] entries, Integer dictionaryId) {
		ResultInfo resultInfo = null;
		try {
			recordService.deleteBatch(entries, dictionaryId);
			resultInfo = success();
		} catch (ParamException e) {
			resultInfo = this.failure(e);
		}
		return resultInfo;
	}

	@RequestMapping("queryForPages")
	@ResponseBody
	public ResultInfo queryForPages(RecordQuery recordQuery) {
		ResultInfo resultInfo = null;
		try {
			List<RecordVo> recordVos = recordService.queryForList(recordQuery);
			resultInfo = success(recordVos);
		} catch (ParamException e) {
			resultInfo = this.failure(e);
		}
		return resultInfo;
	}

	@RequestMapping("queryForExact")
	@ResponseBody
	public ResultInfo queryForExact(String entry, Integer dictionaryId) {
		ResultInfo resultInfo = null;
		try {
			String paraphrase = recordService.queryForExact(entry, dictionaryId);
			if (null != paraphrase) {
				resultInfo = success(paraphrase);
			}else{
				resultInfo=failure(Constant.QUERY_FIULURE);
			}
		} catch (ParamException e) {
			resultInfo = this.failure(e);
		}
		return resultInfo;
	}

}
