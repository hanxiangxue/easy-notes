package com.easynotes.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easynotes.core.base.BaseController;
import com.easynotes.core.base.ResultInfo;
import com.easynotes.core.base.exception.ParamException;
import com.easynotes.core.constant.Constant;
import com.easynotes.core.vo.UserVo;
import com.easynotes.service.UserService;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {
	@Resource
	private UserService userService;

	@RequestMapping("/login/index")
	public String loginIndex() {
		return "login";
	}

	@RequestMapping("/index")
	public String index() {
		return "login";
	}

	@ResponseBody
	@RequestMapping("login")
	public ResultInfo login(String userName, String password) {
		ResultInfo resultInfo = null;
		try {
			UserVo userVo = userService.login(userName, password);
			if (null == userVo) {
				resultInfo = failure(Constant.LOGIN_ERROR_MESSAGE);
			} else {
				resultInfo = success(userVo);
			}
		} catch (ParamException e) {
			resultInfo = failure(e);
		}
		return resultInfo;
	}

	@ResponseBody
	@RequestMapping("register")
	public ResultInfo register(String userName, String password, Integer roleId) {
		ResultInfo resultInfo = null;
		try {
			UserVo userVo = userService.register(userName, password, roleId);
			resultInfo = success(userVo);

		} catch (ParamException e) {
			resultInfo = failure(e);
		}
		return resultInfo;
	}
}
