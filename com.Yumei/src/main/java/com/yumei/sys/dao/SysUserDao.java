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
	 * 保存用户。
	 * 
	 * @param user 用户Entity
	 * @return 操作记录数
	 */
	int saveUser(SysUser user);
	
	/**
	 * 根据用户ID修改用户。
	 * 
	 * @param user 用户Entity
	 * @return 操作记录数
	 */
	int updateUserById(SysUser user);
	
	/**
	 * 根据登陆名获取用户信息。
	 * 
	 * @param loginName 登陆用户名
	 * @return 根据登陆用户名返回用户信息
	 */
	SysUser getUserByName(@Param("loginName") String loginName);
	
	/**
	 * 检查用户名是否已存在
	 * 
	 * @param loginName 登陆用户名
	 * @return 存在个数
	 */
	int checkLoginNameConflict(@Param("loginName")String loginName);
	
	/**
	 * 验证手机号是否已被绑定
	 * 
	 * @param phone 手机号
	 * @return 存在个数
	 */
	int checkPhoneConflict(@Param("phone")String phone);
	
	/**
	 * 更新用户token
	 * 
	 * @param loginName 登陆用户名
	 * @param token token
	 * @return 操作个数
	 */
	int referToken(@Param("loginName")String loginName, @Param("token")String token);
}
