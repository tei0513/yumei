package com.yumei.sys.entity;

import com.yumei.common.entity.BaseEntity;

/**
 * 数据字典用Entity。
 * 
 * @author Tei
 * @Date 2018年11月23日
 */
public class SysDictionary extends BaseEntity {

	private static final long serialVersionUID = -7419676125507647583L;
	
	/** 字典对应code */
	private String code;
	/** 字典对应key */
	private String value;
	/** 字典对应状态 */
	private Integer status;
	/**
	 * 获取 字典对应code
	 *
	 * @return 字典对应code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置 字典对应code
	 *
	 * @param code 字典对应code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取 字典对应key
	 *
	 * @return 字典对应key
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置 字典对应key
	 *
	 * @param value 字典对应key
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取 字典对应状态
	 *
	 * @return 字典对应状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置 字典对应状态
	 *
	 * @param status 字典对应状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
