package com.easynotes.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class MD5Util {

	public static String md5(String pwd) {
		if (pwd == null || "".equals(pwd.trim())) {
			throw new IllegalArgumentException("请输入要加密的内容");
		}

		String encryptText = null;
		try {
			MessageDigest m = MessageDigest.getInstance("md5");
			m.update(pwd.getBytes("UTF8"));
			byte [] s = m.digest();
			for(int i =0;i<s.length;i++){
				s[i]=(byte) (s[i]/3*2+1);
			}
			// m.digest(inputText.getBytes("UTF8"));
			return hex(s);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptText;
	}

	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}
}
