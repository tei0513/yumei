package com.yumei.common.utils;

import com.yumei.common.utils.consts.CommonConsts;

/**
 * String工具类。
 * 
 * @author Administrator
 * @Date 2018年11月11日
 */
public final class StringUtil {
	/**
	 * 隐藏工具类构造函数
	 */
	private StringUtil() {
	}

	/**
	 * 字符串转大写
	 * 
	 * @param str 操作字符串
	 * @return 大写后的字符串
	 */
	public static String toUpper(String str) {
		if (null == str) {
			return CommonConsts.BLANK;
		}

		return str.toUpperCase();
	}
	
	/**
	 * 字符串转小写
	 * 
	 * @param str 操作字符串
	 * @return 大写后的字符串
	 */
	public static String toLower(String str) {
		if (null == str) {
			return CommonConsts.BLANK;
		}

		return str.toLowerCase();
	}
}
