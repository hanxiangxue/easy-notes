package com.easynotes.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.easynotes.core.base.BaseService;
import com.easynotes.core.constant.Constant;
import com.easynotes.core.model.Record;
import com.easynotes.core.query.RecordQuery;
import com.easynotes.core.util.AssertUtil;
import com.easynotes.core.vo.RecordVo;
import com.easynotes.dao.RecordDao;

@Service
public class RecordService extends BaseService<Record> {
	@Resource
	private RecordDao recordDao;

	private Logger logger = LoggerFactory.getLogger(RecordService.class);

	public void addOrUpdate(Record record) {
		String entry = record.getEntry();
		Integer dictionaryId = record.getDictionaryId();
		Record recordResult = queryByPrimaryKey(entry, dictionaryId);
		AssertUtil.isEmpty(record.getParaphrase(), Constant.FAILUER_MESSAGE);
		if (null == recordResult) {
			record.setCreateTime(new Date());
			record.setUpdateTime(new Date());
			record.setState(1);
			AssertUtil.isTrue(this.insert(record) < 1, Constant.FAILUER_MESSAGE);
		} else {
			record.setUpdateTime(new Date());
			AssertUtil.isTrue(this.update(record) < 1, Constant.FAILUER_MESSAGE);
		}
	}

	/**
	 * 通过联合主键进行查询
	 * 
	 * @param key
	 * @return
	 */
	public Record queryByPrimaryKey(String entry, Integer dictionaryId) {
		checkPrimaryKey(entry, dictionaryId);
		return recordDao.queryByPrimaryKey(entry, dictionaryId);
	}

	/**
	 * 通过dictionaryId与entry进行删除
	 * 
	 * @return
	 */
	public void delete(String entry, Integer dictionaryId) {
		try {
			AssertUtil.isTrue(recordDao.delete(entry, dictionaryId) < 1, Constant.FAILUER_MESSAGE);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 通过dictionaryId与entries进行批量删除
	 * 
	 * @param entries
	 * @param dictionaryId
	 * @return
	 */
	public void deleteBatch(String[] entries, Integer dictionaryId) {
		try {
			AssertUtil.isTrue(recordDao.deleteBatch(entries, dictionaryId) < 1, Constant.FAILUER_MESSAGE);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 查询列表
	 * 
	 * @param recordQuery
	 * @return
	 */
	public List<RecordVo> queryForList(RecordQuery recordQuery) {
		List<Record> records = this.queryForPages(recordQuery);
		List<RecordVo> recordVos = null;
		if (null != records) {
			recordVos = new ArrayList<>();
			for (Record record : records) {
				RecordVo recordVo = this.buildVo(record);
				recordVos.add(recordVo);
			}
		}
		return recordVos;
	}

	/**
	 * 精确查询
	 * 
	 * @param entry
	 * @param dictionaryId
	 * @return
	 */
	public String queryForExact(String entry, Integer dictionaryId) {
		checkPrimaryKey(entry, dictionaryId);
		Record record = this.queryByPrimaryKey(entry, dictionaryId);
		AssertUtil.isTrue(null == record, Constant.QUERY_FIULURE);
		AssertUtil.isTrue(1 != record.getState(), Constant.QUERY_FIULURE);
		return record.getParaphrase();
	}

	/**
	 * 构造RecordVo
	 * 
	 * @param record
	 * @return
	 */
	private RecordVo buildVo(Record record) {
		RecordVo recordVo = new RecordVo();
		recordVo.setEntry(record.getEntry());
		recordVo.setParaphrase(record.getParaphrase());
		return recordVo;
	}

	private void checkPrimaryKey(String entry, Integer dictionaryId) {
		AssertUtil.isEmpty(entry, Constant.FAILUER_MESSAGE);
		AssertUtil.isTrue(null == dictionaryId, Constant.FAILUER_MESSAGE);
	}

}
