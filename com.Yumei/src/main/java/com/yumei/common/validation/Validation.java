package com.yumei.common.validation;

import java.util.HashMap;

/**
 * 验证类。
 * 
 * @author Tei
 * @Date 2018年11月18日
 */
public class Validation {
	/** 验证是否通过 */
	private boolean validate;
	/** 错误信息 */
	private HashMap<String, String> errorInfo;
	
	/**
	 * 构造函数
	 */
	public Validation() {
		this.validate = true;
		this.errorInfo = new HashMap<>();
	}
	
	/**
	 * 获取 验证是否通过
	 *
	 * @return 验证是否通过
	 */
	public boolean isValidate() {
		return validate;
	}
	/**
	 * 设置 验证是否通过
	 *
	 * @param validate 验证是否通过
	 */
	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	/**
	 * 获取 错误信息
	 *
	 * @return 错误信息
	 */
	public HashMap<String, String> getErrorInfo() {
		return errorInfo;
	}

	/**
	 * 设置 错误信息
	 *
	 * @param errorInfo 错误信息
	 */
	public void setErrorInfo(HashMap<String, String> errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	/**
	 * 添加错误信息
	 * 
	 * @param errorCode 失败码
	 * @param errorInfo 失败信息
	 */
	public void addErrInfo(String errorCode, String errorInfo) {
		this.errorInfo.put(errorCode, errorInfo);
	}
}
