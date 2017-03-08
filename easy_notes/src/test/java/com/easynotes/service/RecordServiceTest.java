package com.easynotes.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.easynotes.core.base.exception.ParamException;
import com.easynotes.core.model.Record;
import com.easynotes.core.query.RecordQuery;
import com.easynotes.core.vo.RecordVo;

import easy_notes.BaseTest;

public class RecordServiceTest extends BaseTest {
	@Resource
	private RecordService recordService;

	@Test
	public void testAddOrUpdate() {
		Record record = new Record();
		record.setDictionaryId(1);
		record.setEntry("hxx");
		record.setParaphrase("xyy");
		try {
			recordService.addOrUpdate(record);
		} catch (ParamException e) {
			System.err.println(e.getCode() + ":" + e.getErrMessage());
		}
	}

	@Test
	public void testQueryByPrimaryKey() {
		try {
			Record record = recordService.queryByPrimaryKey("hxx", 1);
			System.err.println(record);
		} catch (ParamException e) {
			System.err.println(e.getCode() + ":" + e.getErrMessage());
		}
	}

	@Test
	public void testDelete() {
		try {
			recordService.delete("hxx", 1);
		} catch (ParamException e) {
			System.err.println(e.getCode() + ":" + e.getErrMessage());
		}
	}

	@Test
	public void testDeleteBatchStringArrayInteger() {
		try {
			recordService.deleteBatch(new String[] { "hxx", "ss" }, 1);
		} catch (ParamException e) {
			System.err.println(e.getCode() + ":" + e.getErrMessage());
		}
	}

	@Test
	public void testQueryForList() {
		try {
			RecordQuery recordQuery = new RecordQuery();
			recordQuery.setDictionaryId(1);
			recordQuery.setEntry("hxx");
			recordQuery.setRows(3);
			List<RecordVo> queryForList = recordService.queryForList(recordQuery);
			for (RecordVo recordVo : queryForList) {
				System.err.println(recordVo);
			}

		} catch (ParamException e) {
			System.err.println(e.getCode() + ":" + e.getErrMessage());
		}
	}

	@Test
	public void testQueryForExact() {
		try {
			System.err.println(recordService.queryForExact("hxx", 1));
		} catch (ParamException e) {
			System.err.println(e.getCode() + ":" + e.getErrMessage());
		}
	}

}
