package com.yumei.common.utils;

import com.yumei.common.utils.consts.CommonConsts;

/**
 * String类验证器。
 * 
 * @author Administrator
 * @Date 2018年11月11日
 */
public final class StringChecker {
	/**
	 * 工具类隐藏构造函数
	 */
	private StringChecker() {
	}

	/**
	 * 验证2个字符串是否相等
	 * 
	 * @param str1 验证源1
	 * @param str2 验证源2
	 * @return true:相同,false:不同
	 */
	public static boolean checkIsEquals(String str1, String str2) {
		if (null == str1 || null == str2) {
			return false;
		}
		// 返回比较结果
		return str1.equals(str2);
	}

	/**
	 * 验证字符串是否为空
	 * 
	 * @param str 验证源
	 * @return true:空,false:不为空
	 */
	public static boolean isBlank(String str) {
		if (null == str || CommonConsts.BLANK.equals(str)) {
			return true;
		}
		return false;
	}
}
