package com.yumei.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yumei.common.result.BaseResult;
import com.yumei.common.utils.MessageUtil;
import com.yumei.common.utils.StringChecker;
import com.yumei.common.utils.consts.MessageConsts;
import com.yumei.common.validation.Validation;
import com.yumei.login.dto.LoginInDto;
import com.yumei.login.model.LoginModel;
import com.yumei.login.service.LoginService;
import com.yumei.login.util.consts.LoginConsts;

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
		BaseResult result = new BaseResult();
		Validation validation = checkDate(model);
		// 页面输入值不正确返回错误信息
		if (!validation.isValidate()) {
			result.setResultCode(MessageConsts.ME001V);
			result.setMsg(MessageUtil.getMessageByCode(MessageConsts.ME001V));
			result.setValidation(validation);
			return result;
		}
		
		// model类转dto
		LoginInDto inDto = coverModelToDto(model);
		// 验证用户信息
		result = loginService.checkUserLogin(inDto);
		
		return result;
	}
	
	/**
	 * 验证输入内容
	 * 
	 * @param model 登陆用model
	 * @return 验证信息
	 */
	private Validation checkDate(LoginModel model) {
		Validation validation = new Validation();
		// 检查用户名是否填写
		if (StringChecker.isBlank(model.getLoginName())) {
			validation.addErrInfo(MessageConsts.ME000U, MessageUtil.getMessageByCode(MessageConsts.ME000U));
			validation.setValidate(false);
			return validation;
		}

		// 检查密码是否填写
		if (StringChecker.isBlank(model.getPassword())) {
			validation.addErrInfo(MessageConsts.ME000P, MessageUtil.getMessageByCode(MessageConsts.ME000P));
			validation.setValidate(false);
			return validation;
		}
		return validation;
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
