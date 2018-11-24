package com.yumei.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yumei.common.controller.BaseController;
import com.yumei.common.result.BaseResult;
import com.yumei.common.result.builder.BaseResultBuilder;
import com.yumei.common.utils.MessageUtil;
import com.yumei.common.utils.PasswordUtil;
import com.yumei.common.utils.StringChecker;
import com.yumei.common.utils.consts.MessageConsts;
import com.yumei.common.validation.Validation;
import com.yumei.login.dto.LoginInDto;
import com.yumei.login.model.LoginModel;
import com.yumei.login.service.LoginService;
import com.yumei.login.util.consts.LoginConsts;
import com.yumei.login.vo.LoginVO;

/**
 * 登陆页面Controller。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
@RestController
public class LoginController extends BaseController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BaseResultBuilder resultBuilder;
	
	/**
	 * 登陆页面初始化
	 * 
	 * @return 登录页面相关信息
	 */
	@RequestMapping(value = LoginConsts.INIT, method = RequestMethod.POST)
	public BaseResult init() {
		// 设置登陆随机码
		LoginVO loginVo = new LoginVO();
		BaseResult result = resultBuilder.buildSuccessResult();
		// 设置随机码
		result.setDate(loginVo);
		return result;
	}
	
	/**
	 * 用户登陆
	 * 
	 * @param model 用户登陆用Model类
	 * @return 登陆信息
	 */
	@RequestMapping(value = LoginConsts.LOGIN, method = RequestMethod.POST)
	public BaseResult login(@RequestBody LoginModel model) {
		BaseResult result;
		Validation validation = checkDate(model);
		// 页面输入值不正确返回错误信息
		if (!validation.isValidate()) {
			result = resultBuilder.buildValidationFailResult();
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
		
		// 检查登陆码是否正确
		if (!StringChecker.checkIsEquals(model.getLoginCodeIn(), model.getLoginCodeOut())) {
			validation.addErrInfo(MessageConsts.ME002L, MessageUtil.getMessageByCode(MessageConsts.ME002L));
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
		inDto.setPassword(PasswordUtil.encryptSha256(model.getPassword()));
		
		return inDto;
	}
}
