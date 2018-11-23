package com.yumei.role.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yumei.common.result.BaseResult;
import com.yumei.role.util.consts.RoleConsts;

/**
 * 角色用Controller。
 * 
 * @author Tei
 * @Date 2018年11月19日
 */
@RestController
public class RoleController {
	
	/**
	 * 角色页面初始化
	 * 
	 * @return 初始化参数
	 */
	@RequestMapping(RoleConsts.INIT)
	public BaseResult init() {
		BaseResult result = new BaseResult();
		return result;
	}
}
