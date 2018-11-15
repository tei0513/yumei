package com.yumei.sys.entity;

import com.yumei.common.entity.BaseEntity;

/**
 * 登录用户Entity。
 * 
 * @author Tei
 * @Date 2018年11月13日
 */
public class SysUser extends BaseEntity {

	private static final long serialVersionUID = 58191400644575517L;
	/** 用户ID */
	private Integer userId;
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
	/** 登录令牌 */
	private String token;
	/** 状态 */
	private Integer status;
	/**
	 * 获取 用户ID
	 *
	 * @return 用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置 用户ID
	 *
	 * @param userId 用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
	/**
	 * 获取 登录令牌
	 *
	 * @return 登录令牌
	 */
	public String getToken() {
		return token;
	}
	/**
	 * 设置 登录令牌
	 *
	 * @param token 登录令牌
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * 获取 状态
	 *
	 * @return 状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置 状态
	 *
	 * @param status 状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
	
	
	
	
