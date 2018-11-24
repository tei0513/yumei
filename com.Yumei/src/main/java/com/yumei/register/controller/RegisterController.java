package com.yumei.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yumei.common.controller.BaseController;
import com.yumei.common.result.BaseResult;
import com.yumei.common.utils.MessageUtil;
import com.yumei.common.utils.StringChecker;
import com.yumei.common.utils.consts.MessageConsts;
import com.yumei.common.validation.Validation;
import com.yumei.register.dto.RegisterInDto;
import com.yumei.register.model.RegisterModel;
import com.yumei.register.service.RegisterService;
import com.yumei.register.util.consts.RegisterConsts;

/**
 * 注册用Controller。
 * 
 * @author Tei
 * @Date 2018年11月18日
 */
@RestController
public class RegisterController extends BaseController {
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 注册页面初始化
	 * 
	 * @return 登录页面相关信息
	 */
	@RequestMapping(RegisterConsts.INIT)
	public BaseResult init() {
		BaseResult result = new BaseResult();
		// 设置请求状态码
		result.setResultCode("00");
		return result;
	}
	
	/**
	 * 注册用户信息。
	 * 
	 * @param model 注册用Model
	 * @return 操作结果
	 */
	@RequestMapping(value = RegisterConsts.REGISTER, method = RequestMethod.POST)
	public BaseResult register(@RequestBody RegisterModel model) {
		BaseResult result;
		// 验证填写信息正确性
		Validation validation = checkDate(model);
		if (!validation.isValidate()) {
			result = resultBuilder.buildValidationFailResult();
			// 设置验证信息
			result.setValidation(validation);
			return result;
		}
		
		// Model转inDto
		RegisterInDto inDto = coverModelToDto(model);
		// 用户注册
		result = registerService.register(inDto);
		
		return result;
	}
	
	/**
	 * Model转inDto。
	 * 
	 * @param model 注册用Model
	 * @return 注册用InDto
	 */
	private RegisterInDto coverModelToDto(RegisterModel model) {
		RegisterInDto inDto = new RegisterInDto();
		// 设置登录名
		inDto.setLoginName(model.getLoginName());
		// 设置密码
		inDto.setPassword(model.getPassword());
		// 设置手机号
		inDto.setPhone(model.getPassword());
		// 设置邮箱
		inDto.setEmail(model.getEmail());
		// 设置昵称
		inDto.setNickName(model.getNickName());
		return inDto;
	}
	
	/**
	 * 验证输入信息
	 * 
	 * @param model 注册用Model
	 * @return 验证结果
	 */
	private Validation checkDate(RegisterModel model) {
		Validation validation = new Validation();
		// 验证用户名是否填写
		if (StringChecker.isBlank(model.getLoginName().trim())) {
			validation.addErrInfo(MessageConsts.ME000U, MessageUtil.getMessageByCode(MessageConsts.ME000U));
			validation.setValidate(false);
		}
		
		// 验证密码是否填写
		if (StringChecker.isBlank(model.getPassword().trim())) {
			validation.addErrInfo(MessageConsts.ME000P, MessageUtil.getMessageByCode(MessageConsts.ME000P));
			validation.setValidate(false);
		}
		
		// 验证手机是否填写
		if (StringChecker.isBlank(model.getPhone().trim())) {
			validation.addErrInfo(MessageConsts.ME003R, MessageUtil.getMessageByCode(MessageConsts.ME003R));
			validation.setValidate(false);
		}
		
		// 验证邮箱是否填写
		if (StringChecker.isBlank(model.getEmail().trim())) {
			validation.addErrInfo(MessageConsts.ME002R, MessageUtil.getMessageByCode(MessageConsts.ME002R));
			validation.setValidate(false);
		}
		
		return validation;
	}
}
