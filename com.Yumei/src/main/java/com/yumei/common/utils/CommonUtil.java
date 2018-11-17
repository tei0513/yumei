package com.yumei.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 共通工具类。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
public final class CommonUtil {
	
	/**
	 * 隐藏构造函数
	 */
	private CommonUtil() {
		
	}
	
	/**
	 * 获取request
	 * 
	 * @return request
	 */
	public static HttpServletRequest getRequest() {
	   RequestAttributes ra = RequestContextHolder.getRequestAttributes();
	   ServletRequestAttributes sra = (ServletRequestAttributes) ra;
	   HttpServletRequest request = sra.getRequest();
	   return request;
	}

}
