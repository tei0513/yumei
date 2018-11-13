package com.yumei.sys.entity;

/**
 * 资源Entity。
 * 
 * @author Tei
 * @Date 2018年11月13日
 */
public class SysResource {
	/** 资源ID */
	private Integer resourceId;
	/** 资源级别 */
	private Integer level;
	/** 资源名称 */
	private String resourceName;
	/** 资源路径 */
	private String url;
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
}
