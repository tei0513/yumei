package com.yumei.login.dto;

/**
 * 登陆用InDto。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
public class LoginInDto {
	/** 登陆名 */
	private String loginName;
	/** 密码 */
	private String password;
	
	/**
	 * 获取 登陆名
	 *
	 * @return 登陆名
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 设置 登陆名
	 *
	 * @param loginName 登陆名
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
