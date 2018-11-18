package com.yumei.register.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yumei.common.result.BaseResult;
import com.yumei.common.utils.MessageUtil;
import com.yumei.common.utils.PasswordUtil;
import com.yumei.common.utils.consts.CommonConsts;
import com.yumei.common.utils.consts.MessageConsts;
import com.yumei.common.utils.consts.NumberConsts;
import com.yumei.common.validation.Validation;
import com.yumei.register.dto.RegisterInDto;
import com.yumei.register.service.RegisterService;
import com.yumei.sys.dao.SysUserDao;
import com.yumei.sys.entity.SysUser;

/**
 * 注册用service接口实现类。
 * 
 * @author Tei
 * @Date 2018年11月18日
 */
@Service
public class RegisterServiceImpl implements RegisterService {
	/** 用户DAO */
	@Autowired
	private SysUserDao userDao;
	
	@Override
	public BaseResult register(RegisterInDto inDto) {
		BaseResult result = new BaseResult();
		// 将inDto转成model
		SysUser user = convertInDtoToEntity(inDto);
		// 设置状态
		user.setStatus(CommonConsts.ACTIVE);
		// 验证是否可以注册
		Validation validation = checkCanRegister(user.getLoginName(), user.getPhone());
		if (!validation.isValidate()) {
			result.setMsg(MessageConsts.ME001V);
			result.setMsg(MessageUtil.getMessageByCode(MessageConsts.ME001V));
			result.setValidation(validation);
			return result;
		}
		
		// 保存用户信息
		int count = userDao.saveUser(user);
		String resultCode = "";
		if (count == NumberConsts.NUM_1) {
			resultCode = MessageConsts.MS0000;
		} else {
			resultCode = MessageConsts.ME001R;
		}
		
		result.setResultCode(resultCode);
		result.setMsg(MessageUtil.getMessageByCode(resultCode));
		
		return result;
	}
	
	/**
	 * 验证用户是否可以被注册
	 * 
	 * @param loginName 登陆名
	 * @param phone 手机号
	 * @return 验证信息
	 */
	private Validation checkCanRegister(String loginName, String phone) {
		Validation validation = new Validation();
		int loginNameCount = userDao.checkLoginNameConflict(loginName);
		// 用户名存在返回错误信息
		if (loginNameCount > NumberConsts.NUM_0) {
			validation.addErrInfo(MessageConsts.ME01RU, MessageUtil.getMessageByCode(MessageConsts.ME01RU));
			validation.setValidate(false);
			return validation;
		}
		// 手机号存在返回错误信息
		int phoneCount = userDao.checkPhoneConflict(phone);
		if (phoneCount > NumberConsts.NUM_0) {
			validation.addErrInfo(MessageConsts.ME01RP, MessageUtil.getMessageByCode(MessageConsts.ME01RP));
			validation.setValidate(false);
			return validation;
		}
		
		return validation;
	}

	/**
	 * 注册用InDto转成SysUser类
	 * 
	 * @param inDto 注册用InDto
	 * @return SysUser类
	 */
	private SysUser convertInDtoToEntity(RegisterInDto inDto) {
		SysUser user = new SysUser();
		// 设置登录名
		user.setLoginName(inDto.getLoginName());
		// 设置密码
		user.setPassword(PasswordUtil.encryptSha256(inDto.getPassword()));
		// 设置手机号
		user.setPhone(inDto.getPhone());
		// 设置邮箱
		user.setEmail(inDto.getEmail());
		// 设置昵称
		user.setNickName(inDto.getNickName());
		
		return user;
	}
}
