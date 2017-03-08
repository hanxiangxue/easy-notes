package com.easynotes.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.easynotes.core.base.exception.ParamException;
import com.easynotes.core.model.Dictionary;

import easy_notes.BaseTest;

public class DictionaryServiceTest extends BaseTest {
	@Resource
	private DictionaryService dictionaryService;

	@Test
	public void testAddOrUpdate() {
		Dictionary dictionary = new Dictionary();
		dictionary.setName("test_d");
		dictionary.setType(3);
		dictionary.setId(1);
		Integer userId = 1;
		try {
			dictionaryService.addOrUpdate(dictionary, userId);
		} catch (ParamException e) {
			System.err.println(e.getCode() + ":" + e.getErrMessage());
		}
	}

	@Test
	public void testDelete() {
		try {
			Integer result=dictionaryService.deleteByID(1);
			System.err.println(result);
		} catch (ParamException e) {
			System.err.println(e.getCode() + ":" + e.getErrMessage());
		}

	}
	@Test
	public void testDeleteBatch() {
		Integer [] arr = new Integer[]{1};
		arr[0]=1;
		try {
			Integer result=dictionaryService.deleteBatch(arr);
			System.err.println(result);
		} catch (ParamException e) {
			System.err.println(e.getCode() + ":" + e.getErrMessage());
		}

	}

}
