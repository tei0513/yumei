package com.yumei.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yumei.common.result.BaseResult;
import com.yumei.common.utils.MessageUtil;
import com.yumei.common.utils.StringChecker;
import com.yumei.common.utils.consts.MessageConsts;
import com.yumei.common.validation.Validation;
import com.yumei.login.dto.LoginInDto;
import com.yumei.login.service.LoginService;
import com.yumei.sys.dao.SysUserDao;
import com.yumei.sys.entity.SysUser;
import com.yumei.sys.service.AuthorizeProvide;

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
	/** 权限绑定Dao */
	@Autowired
	private AuthorizeProvide authorizeProvide;

	@Override
	public BaseResult checkUserLogin(LoginInDto inDto) {
		// 初始化返回结果信息
		BaseResult result = new BaseResult();
		// 根据登陆名获取用户信息
		SysUser user = userDao.getUserByName(inDto.getLoginName());

		// 用户名和密码
		Validation validation = checkLoginNameAndPasswd(user, inDto.getPassword());
		if (!validation.isValidate()) {
			result.setResultCode(MessageConsts.ME001V);
			result.setMsg(MessageUtil.getMessageByCode(MessageConsts.ME001V));
			return result;
		}
		
		// 此处为止验证以通过
		result.setResultCode(MessageConsts.MS0000);
		// 绑定用户角色
		authorizeProvide.setAuthorize(user);
		
		return result;
	}

	/**
	 * 验证用户名和密码是否正确
	 * 
	 * @param user   登录用户
	 * @param password 密码
	 * @return 结果信息
	 */
	private Validation checkLoginNameAndPasswd(SysUser user, String password) {
		Validation validation = new Validation();
		// 登陆用户名不存在
		if (null == user) {
			validation.addErrInfo(MessageConsts.ME001U, MessageUtil.getMessageByCode(MessageConsts.ME001U));
			validation.setValidate(false);
			return validation;
		}
		// 数据库中保存的密码
		String orgPass = user.getPassword();
		// 密码错误
		if (!StringChecker.checkIsEquals(orgPass, password)) {
			validation.addErrInfo(MessageConsts.ME001P, MessageUtil.getMessageByCode(MessageConsts.ME001P));
			validation.setValidate(false);
			return validation;
		}
		
		return validation;
	}
}
