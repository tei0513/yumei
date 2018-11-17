package com.yumei.sys.service;

import com.yumei.sys.entity.SysUser;

/**
 * 授权接口。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
public interface AuthorizeProvide {
	
	/**
	 * 根据登陆用户设置用户对应权限
	 * 
	 * @param user 登录用户Entity
	 */
	void setAuthorize(SysUser user);
}
