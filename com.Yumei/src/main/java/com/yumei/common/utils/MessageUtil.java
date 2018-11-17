package com.yumei.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yumei.common.scope.ApplicationScope;

/**
 * 获取返回状态码工具类。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
@Component
public final class MessageUtil {
	
	/** application域 */
	private static ApplicationScope applicationScope;

	/**
	 * 设置 application域
	 *
	 * @param applicationScope application域
	 */
	@Autowired
	public void setApplicationScope(ApplicationScope applicationScope) {
		MessageUtil.applicationScope = applicationScope;
	}

	/**
	 * 根据resultCode返回对应状态信息
	 * 
	 * @param resultCode resultCode
	 * @return 状态信息
	 */
	public static String getMessageByCode(String resultCode) {
		return applicationScope.getResultMsg().get(resultCode);
	}
	
}
