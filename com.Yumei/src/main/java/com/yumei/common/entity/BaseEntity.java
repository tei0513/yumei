package com.yumei.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用Entity。
 * 
 * @author Tei
 * @Date 2018年11月14日
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 创建人 */
	private String createUserName;
	/** 创建时间 */
	private Date createDate;
	/** 修改人 */
	private String updateUserName;
	/** 修改时间 */
	private Date updateDate;
	/**
	 * 获取 创建人
	 *
	 * @return 创建人
	 */
	public String getCreateUserName() {
		return createUserName;
	}
	/**
	 * 设置 创建人
	 *
	 * @param createUserName 创建人
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	/**
	 * 获取 创建时间
	 *
	 * @return 创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置 创建时间
	 *
	 * @param createDate 创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取 修改人
	 *
	 * @return 修改人
	 */
	public String getUpdateUserName() {
		return updateUserName;
	}
	/**
	 * 设置 修改人
	 *
	 * @param updateUserName 修改人
	 */
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	/**
	 * 获取 修改时间
	 *
	 * @return 修改时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置 修改时间
	 *
	 * @param updateDate 修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
