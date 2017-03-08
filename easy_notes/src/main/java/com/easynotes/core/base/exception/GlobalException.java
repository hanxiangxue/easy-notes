package com.easynotes.core.base.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.alibaba.fastjson.JSON;
import com.easynotes.core.constant.Constant;

public class GlobalException  extends SimpleMappingExceptionResolver {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		// 获去默认异常视图页面
		String viewName = determineViewName(ex, request);

		if (StringUtils.isNoneBlank(viewName)) {
			return getModelAndView(viewName, ex);
		}

		if (ex instanceof ParamException) {
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("errorCode", ((ParamException) ex).getCode());
			mv.addObject("errorMsg", ((ParamException) ex).getErrMessage());
			mv.addObject("ctx", request.getContextPath());
			return mv;
		}

		// ajax 请求处理
		PrintWriter pw = null;
		try {
			pw = response.getWriter();

			Map map = new HashMap();
			map.put("errorCode", Constant.FAILUER_CODE);
			map.put("errorMsg", ((ParamException) ex).getErrMessage());
			pw.print(JSON.toJSON(map));
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != pw) {
				pw.close();
			}
		}

		return super.doResolveException(request, response, handler, ex);
	}
}
