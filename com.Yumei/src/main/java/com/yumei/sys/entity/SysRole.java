package com.yumei.sys.entity;

import com.yumei.common.entity.BaseEntity;

/**
 * 登录角色Entity。
 * 
 * @author Tei
 * @Date 2018年11月13日
 */
public class SysRole extends BaseEntity {

	private static final long serialVersionUID = 7161920411211124318L;
	/** 角色ID */
	private Integer roleId;
	/** 角色名称 */
	private String roleName;
	/** 角色CODE */
	private String roleCode;
	/** 状态 */
	private Integer status;
	
	/**
	 * 获取 角色ID
	 *
	 * @return 角色ID
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * 设置 角色ID
	 *
	 * @param roleId 角色ID
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取 角色名称
	 *
	 * @return 角色名称
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * 设置 角色名称
	 *
	 * @param roleName 角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * 获取 状态
	 *
	 * @return 状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置 状态
	 *
	 * @param status 状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取 角色CODE
	 *
	 * @return 角色CODE
	 */
	public String getRoleCode() {
		return roleCode;
	}
	/**
	 * 设置 角色CODE
	 *
	 * @param roleCode 角色CODE
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
}
