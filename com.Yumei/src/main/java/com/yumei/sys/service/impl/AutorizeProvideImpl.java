package com.yumei.sys.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yumei.common.utils.CommonUtil;
import com.yumei.sys.dao.SysResourceDao;
import com.yumei.sys.dao.SysRoleDao;
import com.yumei.sys.entity.SysResource;
import com.yumei.sys.entity.SysRole;
import com.yumei.sys.entity.SysUser;
import com.yumei.sys.entity.UserDetails;
import com.yumei.sys.service.AuthorizeProvide;

/**
 * 授权接口实体类。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
@Service
public class AutorizeProvideImpl implements AuthorizeProvide {
	
	/** 角色DAO */
	@Autowired
	private SysRoleDao roleDao;
	
	/** 资源DAO */
	@Autowired
	private SysResourceDao resourceDao;
	
	@Override
	public void setAuthorize(SysUser user) {
		UserDetails userDetails = new UserDetails();
		// 设置登陆用户名
		userDetails.setLoginName(user.getLoginName());
		// 获取用户角色
		List<SysRole> roleList = roleDao.getRoleByUser(user.getUserId());
		// 设置用户角色列表
		userDetails.setRoles(roleList);
		// 根据用户ID获取相关资源
		List<SysResource> resourceList = resourceDao.getResourceByUserId(user.getUserId());
		// 设置可访问资源列表
		userDetails.setResources(resourceList);
		// 保存权限到session
		saveToSession(userDetails);
	}
	

	/**
	 * 将用户信息保存到sesssion中
	 * 
	 * @param userDetails 用户对应权限类
	 */
	private void saveToSession(UserDetails userDetails) {
		// 获取request
		HttpServletRequest request = CommonUtil.getRequest();
		
		if (null != request) {
			// 获取session
			HttpSession session = request.getSession();
			// 将信息保存到session中
			session.setAttribute("user_details", userDetails);
		}
	}
}
