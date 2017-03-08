package com.easynotes.core.vo;

import com.easynotes.core.base.BaseVo;
import com.easynotes.core.model.User;

/**
 * userVo
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class UserVo extends BaseVo<User>{
	private String userID;//经过base64加密的用户id
	private String userName;//用户名

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserVo [userID=" + userID + ", userName=" + userName + "]";
	}
	
}
