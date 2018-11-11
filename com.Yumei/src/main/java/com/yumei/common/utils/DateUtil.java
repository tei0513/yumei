package com.yumei.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.yumei.common.utils.consts.CommonConsts;

/**
 * 日期工具类。
 * 
 * @author Administrator
 * @Date 2018年11月11日
 */
public final class DateUtil {
	/**
	 * 隐藏工具类构造函数
	 */
	private DateUtil() {
	}

	/** 线程专有格式转换器 */
	private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

	// 初始化格式转换器
	static {
		SimpleDateFormat sdf = new SimpleDateFormat(CommonConsts.DEFAULT_DATE_FORMAT);
		threadLocal.set(sdf);
	}

	/**
	 * 将String类型转换为日期类型<br>
	 * [备考]默认转换格式yyyy-MM-dd
	 * 
	 * @param str 日期格式字符串
	 * @return 转化后的Date类型
	 */
	public static Date convertToDate(String str) {
		return convertToDate(str, CommonConsts.DEFAULT_DATE_FORMAT);
	}

	/**
	 * 将String类型转换为日期类型
	 * 
	 * @param str    日期格式字符串
	 * @param format 转换格式
	 * @return 转化后的Date类型
	 */
	public static Date convertToDate(String str, String format) {
		Date date = null;
		if (null == str || CommonConsts.BLANK.equals(str)) {
			return date;
		}

		if (null == format && CommonConsts.BLANK.equals(format)) {
			return date;
		}
		// 定义日期转换格式
		setDateFormat(format);
		
		SimpleDateFormat simpleDateFormat = threadLocal.get();
		try {
			date = simpleDateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}

	/**
	 * 定义日期转换格式
	 * 
	 * @param format 日期格式
	 */
	private static void setDateFormat(String format) {
		// 默认类型不做任何操作
		if (CommonConsts.DEFAULT_DATE_FORMAT.equals(format)) {
			return;
		}
		// 定义日期格式转换器
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// 保存日期格式转换器
		threadLocal.set(sdf);
	}
}
