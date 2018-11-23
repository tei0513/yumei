package com.yumei.sys.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Filter公用方法。
 * 
 * @author Tei
 * @Date 2018年11月19日
 */
public class CommonFilterUtil {
	/** 放行URL集合 */
	List<String> excludeUri;
	
	/** 项目名 */
	private static final String PROJECT_NAME = "/Yumei";
	
	/**
	 * 检查URI是否需要被过滤器检查
	 * 
	 * @param uri uri
	 * @return true:需要检查,false:放行
	 */
	protected boolean checkShouldFilter(String uri) {
		// 初始化
		addExcludeUrl();
		
		// 检查uri是否可以被放行
		for (String s:excludeUri) {
			if (uri.contains(s)) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * 初始化函數
	 */
	private void addExcludeUrl() {
		this.excludeUri = new ArrayList<String>();
		
		// 添加不需要過濾的URI
		this.excludeUri.add("/login");
		this.excludeUri.add("/register");
	}
	
	/**
	 * 获取访问URL
	 * 
	 * @param request request
	 * @return 访问URL
	 */
	protected String getRequestURI(HttpServletRequest request) {
		String uri = request.getRequestURI();
		
		// 判断是否是已项目名作为开头
		if (uri.startsWith(PROJECT_NAME)) {
			uri = uri.substring(PROJECT_NAME.length(), uri.length());
		}
		
		return uri;
	}
}
