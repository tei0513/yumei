package com.yumei.utils;

import org.junit.Test;

import com.yumei.common.utils.PasswordUtil;

/**
 * 测试加密工具类
 * 
 * @author Administrator
 * @Date 2018年11月11日
 */
public class PasswordUtilTest {

	/**
	 * 测试sha256加密
	 */
	@Test
	public void testEncode() {
		// 密码加密
		String encryptSha256 = PasswordUtil.encryptSha256("qweqwe123");
		encryptSha256.length();
		
	}
}
