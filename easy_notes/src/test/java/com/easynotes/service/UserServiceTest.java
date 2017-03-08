package com.easynotes.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.easynotes.core.base.exception.ParamException;
import com.easynotes.core.vo.UserVo;
import com.easynotes.service.UserService;

import easy_notes.BaseTest;

public class UserServiceTest extends BaseTest{
	
	@Resource
	private UserService userService;
	@Test
	public void loginTest(){
		String userName="admin";
		String password="123456";
		try{
			UserVo userVo=userService.login(userName, password);
			System.err.println(userVo);
		}catch(ParamException e){
			System.err.println(e.getCode()+":"+e.getErrMessage());
		}
	}
	@Test
	public void registerTest(){
		String userName="hxx1";
		String password="hxx123456";
		Integer roleId=3;
		try{
			
			UserVo userVo=userService.register(userName, password, roleId);
			System.err.println(userVo);
		}catch(ParamException e){
			System.err.println(e.getCode()+":"+e.getErrMessage());
		}
	}

}
