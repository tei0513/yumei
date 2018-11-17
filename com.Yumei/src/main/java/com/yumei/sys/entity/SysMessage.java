package com.yumei.sys.entity;

/**
 * 状态码用Entity。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
public class SysMessage {
	/** 状态码 */
	private String resultCode;
	/** 状态信息 */
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
	 * 获取 状态信息
	 *
	 * @return 状态信息
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * 设置 状态信息
	 *
	 * @param message 状态信息
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
