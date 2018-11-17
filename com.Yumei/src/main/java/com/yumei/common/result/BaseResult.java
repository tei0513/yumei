package com.yumei.common.result;

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
	
	/** 异常信息 */
	private String errorMsg;

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
	 * 获取 异常信息
	 *
	 * @return 异常信息
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * 设置 异常信息
	 *
	 * @param errorMsg 异常信息
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
}
