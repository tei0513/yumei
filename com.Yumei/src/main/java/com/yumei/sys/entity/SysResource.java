package com.yumei.sys.entity;


import com.yumei.common.entity.BaseEntity;

/**
 * 资源Entity。
 * 
 * @author Tei
 * @Date 2018年11月13日
 */
public class SysResource extends BaseEntity {

	private static final long serialVersionUID = -4360828751712361495L;
	/** 资源ID */
	private Integer resourceId;
	/** 资源级别 */
	private Integer level;
	/** 资源名称 */
	private String resourceName;
	/** 资源路径 */
	private String url;
	/** 资源状态 */
	private Integer status;
	/** 资源CODE */
	private String resourceCode;
	/**
	 * 获取 资源ID
	 *
	 * @return 资源ID
	 */
	public Integer getResourceId() {
		return resourceId;
	}
	/**
	 * 设置 资源ID
	 *
	 * @param resourceId 资源ID
	 */
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	/**
	 * 获取 资源级别
	 *
	 * @return 资源级别
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置 资源级别
	 *
	 * @param level 资源级别
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取 资源名称
	 *
	 * @return 资源名称
	 */
	public String getResourceName() {
		return resourceName;
	}
	/**
	 * 设置 资源名称
	 *
	 * @param resourceName 资源名称
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	/**
	 * 获取 资源路径
	 *
	 * @return 资源路径
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置 资源路径
	 *
	 * @param url 资源路径
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取 资源状态
	 *
	 * @return 资源状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置 资源状态
	 *
	 * @param status 资源状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取 资源CODE
	 *
	 * @return 资源CODE
	 */
	public String getResourceCode() {
		return resourceCode;
	}
	/**
	 * 设置 资源CODE
	 *
	 * @param resourceCode 资源CODE
	 */
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}
}
