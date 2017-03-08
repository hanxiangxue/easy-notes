package com.easynotes.dao;

import com.easynotes.core.base.BaseDao;
import com.easynotes.core.model.User;

public interface UserDao extends BaseDao<User> {
	/**
	 * 通过用户名查询用户数据
	 * 
	 * @param userName
	 * @return
	 */
	User findUserByName(String userName);

	/**
	 * 更新用户最近登录时间
	 * 
	 * @param id
	 */
	void updateLastLoginTime(Integer id);
}