package com.yumei.common.dto;

import java.io.Serializable;

/**
 * 通用InDto类。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
public class BaseInDto implements Serializable {

	private static final long serialVersionUID = -7448520389850278301L;
	
	/** 状态码 */
	private String resultCode;
	/** 状态码信息 */
	private String message;
	/**
	 * 获取 状态码
	 *
	 * @return 状态码
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**
	 * 设置 状态码
	 *
	 * @param resultCode 状态码
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * 获取 状态码信息
	 *
	 * @return 状态码信息
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 设置 状态码信息
	 *
	 * @param message 状态码信息
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
