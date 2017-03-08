package com.easynotes.service;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.easynotes.core.base.BaseService;
import com.easynotes.core.constant.Constant;
import com.easynotes.core.model.User;
import com.easynotes.core.util.AssertUtil;
import com.easynotes.core.util.Base64Util;
import com.easynotes.core.util.MD5Util;
import com.easynotes.core.vo.UserVo;
import com.easynotes.dao.UserDao;

@Service
public class UserService extends BaseService<User> {

	@Resource
	private UserDao userDao;

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	/**
	 * 登录操作
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public UserVo login(String userName, String password) {
		checkLoginParam(userName, password);
		User user = userDao.findUserByName(userName);
		AssertUtil.isTrue(null == user, Constant.LOGIN_ERROR_MESSAGE);
		AssertUtil.isTrue(1!=user.getState(), Constant.LOGIN_ERROR_MESSAGE);
		AssertUtil.isTrue(!MD5Util.md5(password).equals(user.getPassword()), Constant.LOGIN_ERROR_MESSAGE);
		UserVo userVo = buildUserVo(user);
		try {
			userDao.updateLastLoginTime(user.getId());//更新最近登录时间
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return userVo;
	}

	/**
	 * 注册操作
	 * 
	 * @param userName
	 * @param password
	 * @param roleId
	 * @return
	 */
	public UserVo register(String userName, String password, Integer roleId) {
		checkRegisterParam(userName, password, roleId);
		User user = buildUser(userName, password, roleId);
		AssertUtil.isTrue(null!=userDao.findUserByName(userName), Constant.RESISTER_USERNAME_ERROR_MESSGAE);
		AssertUtil.isTrue(this.insert(user) < 1, Constant.REGISTER_ERROR_MESSAGE);
		UserVo userVo = this.buildUserVo(user);
		return userVo;
	}

	/**
	 * 创建userVo
	 * 
	 * @param user
	 * @return
	 */
	private UserVo buildUserVo(User user) {
		UserVo userVo = new UserVo();
		userVo.setUserID(Base64Util.encoderUserID(user.getId()));
		userVo.setUserName(user.getName());
		return userVo;
	}

	/**
	 * 创建user
	 * 
	 * @param userName用户名
	 * @param password密码
	 * @param roleId角色id
	 * @return
	 */
	private User buildUser(String userName, String password, Integer roleId) {
		User user = new User();
		user.setName(userName);
		user.setPassword(MD5Util.md5(password));// 密码加密
		user.setRoleId(roleId);
		user.setCreateTime(new Date());
		user.setState(1);
		user.setLastLoginTime(new Date());
		return user;
	}

	/**
	 * 登录参数校验
	 * 
	 * @param userName
	 * @param password
	 */
	private void checkLoginParam(String userName, String password) {
		AssertUtil.isEmpty(userName, Constant.LOGIN_ERROR_MESSAGE);
		AssertUtil.isEmpty(password, Constant.LOGIN_ERROR_MESSAGE);
	}

	/**
	 * 注册参数校验
	 * 
	 * @param userName
	 * @param password
	 * @param roleId
	 */
	private void checkRegisterParam(String userName, String password, Integer roleId) {
		AssertUtil.isEmpty(userName, Constant.REGISTER_ERROR_MESSAGE);
		AssertUtil.isEmpty(password, Constant.REGISTER_ERROR_MESSAGE);
		AssertUtil.isEmpty(password, Constant.REGISTER_ERROR_MESSAGE);

	}

}
