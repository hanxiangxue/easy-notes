package com.easynotes.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.easynotes.core.constant.Constant;
import com.easynotes.core.util.AssertUtil;
import com.easynotes.core.util.LoginUserUtil;
import com.easynotes.service.UserService;

public class UserLoginInterceptor extends HandlerInterceptorAdapter {
	@Resource
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/**
		 * 1.获取用户id 2.校验是否存在用户记录
		 */
		Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
		AssertUtil.isTrue(null == userId || 0 == userId || null == userService.queryByID(userId),
				Constant.LOGIN_FIRST);
		return true;
	}
}
