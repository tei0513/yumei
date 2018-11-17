package com.yumei.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yumei.common.result.BaseResult;
import com.yumei.login.dto.LoginInDto;
import com.yumei.login.model.LoginModel;
import com.yumei.login.service.LoginService;
import com.yumei.login.util.LoginConsts;

/**
 * 登陆页面Controller。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * 登陆页面初始化
	 * 
	 * @return 登录页面相关信息
	 */
	@RequestMapping(LoginConsts.INIT)
	public BaseResult init() {
		BaseResult result = new BaseResult();
		// 设置请求状态码
		result.setResultCode("00");
		return result;
	}
	
	/**
	 * 用户登陆
	 * 
	 * @param model 用户登陆用Model类
	 * @return 登陆信息
	 */
	@RequestMapping(LoginConsts.LOGIN)
	public BaseResult login(LoginModel model) {
		// model类转dto
		LoginInDto inDto = coverModelToDto(model);
		// 验证用户信息
		BaseResult result = loginService.checkUserLogin(inDto);
		
		return result;
	}
	
	/**
	 * Model类转Dto
	 * 
	 * @param model 用户登陆用Model类
	 * @return 用户登陆用InDto类
	 */
	private LoginInDto coverModelToDto(LoginModel model) {
		LoginInDto inDto = new LoginInDto();
		// 设置用户名
		inDto.setLoginName(model.getLoginName());
		// 设置密码
		inDto.setPassword(model.getPassword());
		
		return inDto;
	}
}
