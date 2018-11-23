package com.yumei.login.vo;

import com.yumei.common.utils.CommonUtil;
import com.yumei.common.utils.consts.NumberConsts;

/**
 * LoginVO对象。
 * 
 * @author Tei
 * @Date 2018年11月23日
 */
public class LoginVO {
	/**
	 * 构造函数
	 */
	public LoginVO() {
		this.loginCode = CommonUtil.initToken(NumberConsts.NUM_5);
	}
	
	/** 登陆码 */
	private String loginCode;
	
	/**
	 * 获取 登陆码
	 *
	 * @return 登陆码
	 */
	public String getLoginCode() {
		return loginCode;
	}
	
}
