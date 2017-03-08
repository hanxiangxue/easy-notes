package com.easynotes.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easynotes.core.base.BaseService;
import com.easynotes.core.constant.Constant;
import com.easynotes.core.model.Dictionary;
import com.easynotes.core.query.DictionaryQuery;
import com.easynotes.core.util.AssertUtil;
import com.easynotes.core.vo.DictionaryVo;
import com.easynotes.dao.DictionaryDao;
/**
 * 本类缺少参数校验
 * @author Administrator
 *
 */
@Service
public class DictionaryService extends BaseService<Dictionary> {
	@Resource
	private DictionaryDao dictionaryDao;
	/**
	 * 添加或者修改操作
	 * @param dictionary
	 * @param userId
	 */
	public void addOrUpdate(Dictionary dictionary, Integer userId) {
		checkParam(dictionary);
		Integer dictionaryId = dictionary.getId();
		if (null == dictionaryId) {
			//设置额外参数，之后进行添加
			AssertUtil.isTrue(null!=dictionaryDao.queryByNameAndUserId(dictionary.getName(),userId), Constant.FAILUER_MESSAGE);
			dictionary.setCreateTime(new Date());
			dictionary.setLastUpdateTime(new Date());
			dictionary.setUserId(userId);
			dictionary.setState(1);
			AssertUtil.isTrue(this.insert(dictionary)<1, Constant.FAILUER_MESSAGE);
		} else {
			//通过dictionaryId进行是否存在的判断，如果存在，则修改，否则抛出异常
			AssertUtil.isTrue(null==dictionaryDao.queryByID(dictionaryId), Constant.FAILUER_MESSAGE);
			dictionary.setLastUpdateTime(new Date());
			AssertUtil.isTrue(this.update(dictionary)<1, Constant.FAILUER_MESSAGE);
		}
	}

	private void checkParam(Dictionary dictionary) {
		
		
	}

	/**
	 * 传入DictionaryQuery，返回对应的DictionaryVo组成的集合
	 * 
	 * @param query
	 * @return
	 */
	public List<DictionaryVo> queryVoForList(DictionaryQuery query) {
		List<Dictionary> dictionaries = this.queryForPages(query);
		List<DictionaryVo> dictionaryVos = new ArrayList<DictionaryVo>();
		for (Dictionary dictionary : dictionaries) {
			DictionaryVo dictionaryVo = buildDictionaryVo(dictionary);
			dictionaryVos.add(dictionaryVo);
		}
		return dictionaryVos;
	}

	/**
	 * 传入Dictionary，传回DictionaryVo
	 * 
	 * @param dictionary
	 * @return
	 */
	private DictionaryVo buildDictionaryVo(Dictionary dictionary) {
		DictionaryVo dictionaryVo = new DictionaryVo();
		dictionaryVo.setId(dictionary.getId());
		dictionaryVo.setName(dictionary.getName());
		dictionaryVo.setType(dictionary.getType());
		return dictionaryVo;
	}

}
