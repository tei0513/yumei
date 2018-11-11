package com.yumei.utils;

import java.util.Date;

import org.junit.Test;

import com.yumei.common.utils.DateUtil;

/**
 * 日期工具测试类。
 * 
 * @author Administrator
 * @Date 2018年11月11日
 */


public class DateUtilTest {
	
	/**
	 * 测试日期转化
	 */
	@Test
	public void testConvertDate() {
		Date convertToDate = DateUtil.convertToDate("2018-11-11 20:41:18", "yyyy-MM-dd HH:mm:ss");
		convertToDate.getTime();
	}
}
