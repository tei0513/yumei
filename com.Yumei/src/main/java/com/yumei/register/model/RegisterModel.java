package com.yumei.register.model;

/**
 * 注册用Model。
 * 
 * @author Tei
 * @Date 2018年11月18日
 */
public class RegisterModel {
	/** 登录名 */
	private String loginName;
	/** 昵称 */
	private String nickName;
	/** 密码 */
	private String password;
	/** 手机号 */
	private String phone;
	/** 邮箱 */
	private String email;
	/**
	 * 获取 登录名
	 *
	 * @return 登录名
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 设置 登录名
	 *
	 * @param loginName 登录名
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * 获取 昵称
	 *
	 * @return 昵称
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 设置 昵称
	 *
	 * @param nickName 昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	 * 获取 手机号
	 *
	 * @return 手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置 手机号
	 *
	 * @param phone 手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取 邮箱
	 *
	 * @return 邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置 邮箱
	 *
	 * @param email 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
