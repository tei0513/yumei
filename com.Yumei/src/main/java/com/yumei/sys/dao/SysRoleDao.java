package com.yumei.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yumei.sys.entity.SysRole;

/**
 * 角色DAO接口。
 * 
 * @author Tei
 * @Date 2018年11月14日
 */
public interface SysRoleDao {
	
	/**
	 * 根据用户ID获取对应角色
	 * 
	 * @param userId 用户ID
	 * @return 用户对应角色
	 */
	List<SysRole> getRoleByUser(@Param("userId")Integer userId);
	
	
}
