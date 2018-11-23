package com.yumei.login.service;

import com.yumei.common.result.BaseResult;
import com.yumei.login.dto.LoginInDto;

/**
 * 登陆用service接口。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
public interface LoginService {
	/**
	 * 检查用户登陆信息
	 * 
	 * @param inDto 登陆用inDto
	 * @return 登陆信息
	 */
	BaseResult checkUserLogin(LoginInDto inDto);
	
}
