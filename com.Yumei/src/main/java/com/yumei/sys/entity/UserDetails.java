package com.yumei.sys.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 用户对应权限类。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
public class UserDetails implements Serializable {
	
	private static final long serialVersionUID = 7389383688143487875L;
	
	/** 登陆用户名 */
	private String loginName;
	/** 用户角色列表 */
	private List<SysRole> roles;
	/** 可访问资源列表 */
	private List<SysResource> resources;
	/**
	 * 获取 登陆用户名
	 *
	 * @return 登陆用户名
	 */
	public String loginName() {
		return loginName;
	}
	/**
	 * 设置 登陆用户名
	 *
	 * @param loginName 登陆用户名
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * 获取 用户角色列表
	 *
	 * @return 用户角色列表
	 */
	public List<SysRole> getRoles() {
		return roles;
	}
	/**
	 * 设置 用户角色列表
	 *
	 * @param roles 用户角色列表
	 */
	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
	/**
	 * 获取 可访问资源列表
	 *
	 * @return 可访问资源列表
	 */
	public List<SysResource> getResources() {
		return resources;
	}
	/**
	 * 获取 登陆用户名
	 *
	 * @return 登陆用户名
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 设置 可访问资源列表
	 *
	 * @param resources 可访问资源列表
	 */
	public void setResources(List<SysResource> resources) {
		this.resources = resources;
	}
	
}
