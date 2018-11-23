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
	/** 输出验证码 */
	private String loginCodeOut;
	/** 输入验证码 */
	private String loginCodeIn;
	
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
	/**
	 * 获取 输出验证码
	 *
	 * @return 输出验证码
	 */
	public String getLoginCodeOut() {
		return loginCodeOut;
	}
	/**
	 * 设置 输出验证码
	 *
	 * @param loginCodeOut 输出验证码
	 */
	public void setLoginCodeOut(String loginCodeOut) {
		this.loginCodeOut = loginCodeOut;
	}
	/**
	 * 获取 输入验证码
	 *
	 * @return 输入验证码
	 */
	public String getLoginCodeIn() {
		return loginCodeIn;
	}
	/**
	 * 设置 输入验证码
	 *
	 * @param loginCodeIn 输入验证码
	 */
	public void setLoginCodeIn(String loginCodeIn) {
		this.loginCodeIn = loginCodeIn;
	}
}
