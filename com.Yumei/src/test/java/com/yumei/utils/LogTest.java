package com.yumei.utils;

import org.junit.Test;

import com.yumei.common.utils.LogUtil;

/**
 * 日志输出工具类。
 * 
 * @author Tei
 * @Date 2018年11月24日
 */
public class LogTest {
	
	/**
	 * 测试输出日志
	 */
	@Test
	public void testLogOut() {
		LogUtil.controllerLog("controller层log");
		LogUtil.serviceLog("service层log");
		LogUtil.errorLog("error Msg");
	}
}
