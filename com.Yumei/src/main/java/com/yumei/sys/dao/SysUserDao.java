package com.yumei.sys.dao;

import org.apache.ibatis.annotations.Param;

import com.yumei.sys.entity.SysUser;

/**
 * 登陆用户DAO接口。
 * 
 * @author Tei
 * @Date 2018年11月13日
 */
public interface SysUserDao {
	/**
	 * 根据登陆名获取用户信息。
	 * 
	 * @param loginName 登陆用户名
	 * @return 根据登陆用户名返回用户信息
	 */
	SysUser getUserByName(@Param("loginName") String loginName);
}
