package com.yumei.common.result;

import com.yumei.common.validation.Validation;

/**
 * 通用接口返回类型。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
public class BaseResult {

	/** 请求状态码 */
	private String resultCode;
	
	/** 请求返回参数 */
	private Object date;
	
	/** 状态码信息 */
	private String msg;
    
	/** 验证信息 */
	private Validation validation;
	
	/** 随机令牌 */
	private String token;
	/**
	 * 获取 请求状态码
	 *
	 * @return 请求状态码
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * 设置 请求状态码
	 *
	 * @param resultCode 请求状态码
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * 获取 请求返回参数
	 *
	 * @return 请求返回参数
	 */
	public Object getDate() {
		return date;
	}

	/**
	 * 设置 请求返回参数
	 *
	 * @param date 请求返回参数
	 */
	public void setDate(Object date) {
		this.date = date;
	}

	/**
	 * 获取 状态码信息
	 *
	 * @return 状态码信息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 设置 状态码信息
	 *
	 * @param msg 状态码信息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 获取 验证信息
	 *
	 * @return 验证信息
	 */
	public Validation getValidation() {
		return validation;
	}

	/**
	 * 设置 验证信息
	 *
	 * @param validation 验证信息
	 */
	public void setValidation(Validation validation) {
		this.validation = validation;
	}

	/**
	 * 获取 随机令牌
	 *
	 * @return 随机令牌
	 */
	public String getToken() {
		return token;
	}

	/**
	 * 设置 随机令牌
	 *
	 * @param token 随机令牌
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
}
