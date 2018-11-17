package com.yumei.login.model;

/**
 * 用户登陆用Model类。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
public class LoginModel {
	/** 用户名 */
	private String loginName;
	/** 密码 */
	private String password;
	/**
	 * 获取 用户名
	 *
	 * @return 用户名
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 设置 用户名
	 *
	 * @param loginName 用户名
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * 获取 密码
	 *
	 * @return 密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置 密码
	 *
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
}
