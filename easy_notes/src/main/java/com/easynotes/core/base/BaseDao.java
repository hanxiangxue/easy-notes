package com.easynotes.core.base;

import java.util.List;

/**
 * 基础的dao层接口
 * 
 * @author Administrator
 *
 */
public interface BaseDao<T> {
	/**
	 * 插入单条数据，返回值小于1则失败
	 * 
	 * @param t
	 * @return
	 */
	Integer insert(T t);

	/**
	 * 插入多条数据，返回插入成功的数量
	 * 
	 * @return
	 */
	Integer insertBatch(List<T> entries);

	/**
	 * 通过id进行数据的删除
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteByID(Integer id);

	/**
	 * 通过提供的ids数组进行数据的批量删除
	 * 
	 * @param ids
	 * @return
	 */
	Integer deleteBatch(Integer[] ids);

	/**
	 * 传入数据，进行更新
	 * 
	 * @param t
	 * @return
	 */
	Integer update(T t);

	/**
	 * 根据id进行查询
	 * 
	 * @param t
	 * @return
	 */
	T queryByID(Integer id);

	/**
	 * 通过传入query类进行多条数据的查询
	 * 
	 * @param query
	 * @return
	 */
	List<T> queryForPages(BaseQuery<T> query);
}
