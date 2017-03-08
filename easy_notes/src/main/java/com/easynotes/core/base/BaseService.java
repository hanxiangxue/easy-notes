package com.easynotes.core.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public abstract class BaseService<T> {
	@Autowired
	private BaseDao<T> baseDao;

	/**
	 * 插入单条数据，返回值小于1则失败
	 * 
	 * @param t
	 * @return
	 */
	public Integer insert(T t) {
		return baseDao.insert(t);
	}

	/**
	 * 插入多条数据，返回插入成功的数量
	 * 
	 * @return
	 */
	public Integer insertBatch(List<T> entries) {
		return baseDao.insertBatch(entries);
	}

	/**
	 * 通过id进行数据的删除
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteByID(Integer id) {
		return baseDao.deleteByID(id);
	}

	/**
	 * 通过提供的ids数组进行数据的批量删除
	 * 
	 * @param ids
	 * @return
	 */
	public Integer deleteBatch(Integer[] ids) {
		return baseDao.deleteBatch(ids);
	}

	/**
	 * 传入数据，进行更新
	 * 
	 * @param t
	 * @return
	 */
	public Integer update(T t) {
		return baseDao.update(t);
	}

	/**
	 * 根据id进行查询
	 * 
	 * @param t
	 * @return
	 */
	public T queryByID(Integer id) {
		return baseDao.queryByID(id);
	}

	/**
	 * 通过传入query类进行多条数据的查询
	 * 
	 * @param query
	 * @return
	 */
	public List<T> queryForPages(BaseQuery<T> query) {

		PageHelper.startPage(query.getPageNumber(), query.getRows());
		// selectAll查询出的List即为上面定义的page
		List<T> entries = baseDao.queryForPages(query);
		// 注意：
		// 使用PageHelper.startPage只是针对接下来的一条查询语句，
		PageInfo<T> info = new PageInfo<T>(entries);
		List<T> result = info.getList();
		return result;
	}


}
