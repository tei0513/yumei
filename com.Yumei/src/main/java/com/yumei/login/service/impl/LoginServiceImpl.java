package com.yumei.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yumei.common.result.BaseResult;
import com.yumei.common.utils.MessageUtil;
import com.yumei.common.utils.StringChecker;
import com.yumei.common.utils.consts.MessageConsts;
import com.yumei.login.dto.LoginInDto;
import com.yumei.login.service.LoginService;
import com.yumei.sys.dao.SysUserDao;
import com.yumei.sys.entity.SysUser;

/**
 * 登用用service实现类。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
@Service
public class LoginServiceImpl implements LoginService {

	/** 用户Dao */
	@Autowired
	private SysUserDao userDao;

	@Override
	public BaseResult checkUserLogin(LoginInDto inDto) {
		// 初始化返回结果信息
		BaseResult result = new BaseResult();
		// 根据登陆名获取用户信息
		SysUser user = userDao.getUserByName(inDto.getLoginName());

		// 验证用户名和密码是否以填写
		result = checkLoginNameAndPasswordNotEmpty(inDto, result);
		if (StringChecker.isBlank(result.getErrorMsg())) {
			return result;
		}

		// 验证用户是否存在
		result = checkUserName(user, result);
		if (StringChecker.isBlank(result.getErrorMsg())) {
			return result;
		}
		
		// 验证密码是否正确
		result = checkPassword(user.getPassword(), inDto.getPassword(), result);
		if (StringChecker.isBlank(result.getErrorMsg())) {
			return result;
		}
		
		// 此处为止验证以通过
		result.setResultCode(MessageConsts.MS0000);
		
		return result;
	}

	/**
	 * 验证用户名和密码是否以填写
	 * 
	 * @param inDto  登陆用inDto
	 * @param result 结果信息
	 * @return 结果信息
	 */
	private BaseResult checkLoginNameAndPasswordNotEmpty(LoginInDto inDto, BaseResult result) {
		// 检查用户名是否填写
		if (StringChecker.isBlank(inDto.getLoginName())) {
			// 设置请求状态码
			result.setResultCode(MessageConsts.ME000U);
			// 设置异常信息
			result.setErrorMsg(MessageUtil.getMessageByCode(MessageConsts.ME000U));
			return result;
		}

		// 检查密码是否填写
		if (StringChecker.isBlank(inDto.getPassword())) {
			// 设置请求状态码
			result.setResultCode(MessageConsts.ME000P);
			// 设置异常信息
			result.setErrorMsg(MessageUtil.getMessageByCode(MessageConsts.ME000P));
			return result;
		}

		return result;
	}

	/**
	 * 验证用户名是否存在
	 * 
	 * @param user   登录用户
	 * @param result 结果信息
	 * @return 结果信息
	 */
	private BaseResult checkUserName(SysUser user, BaseResult result) {
		if (null == user) {
			// 设置请求状态码
			result.setResultCode(MessageConsts.ME001U);
			// 设置异常信息
			result.setErrorMsg(MessageUtil.getMessageByCode(MessageConsts.ME001U));
		}
		return result;
	}

	/**
	 * 验证密码是否正确
	 * 
	 * @param nagPassword 原始密码
	 * @param password    输入密码
	 * @param result      结果信息
	 * @return 结果信息
	 */
	private BaseResult checkPassword(String nagPassword, String password, BaseResult result) {
		// 验证密码是否正确
		if (!StringChecker.checkIsEquals(nagPassword, password)) {
			// 设置请求状态码
			result.setResultCode(MessageConsts.ME001P);
			// 设置异常信息
			result.setErrorMsg(MessageUtil.getMessageByCode(MessageConsts.ME001P));
		}

		return result;
	}
}
