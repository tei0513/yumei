package com.yumei.common.aop;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.yumei.common.utils.CommonUtil;
import com.yumei.common.utils.RedisUtil;
import com.yumei.common.utils.consts.CommonConsts;
import com.yumei.common.utils.consts.NumberConsts;
import com.yumei.common.utils.consts.RedisConsts;

/**
 * Controller层Aop。
 * 
 * @author Tei
 * @Date 2018年11月23日
 */
@Component
@Aspect
@Order(NumberConsts.NUM_10)
public class ControllerAop {
	/**
	 * 设置token属性
	 */
	@After("@annotation(org.springframework.web.bind.annotation.RequestMapping)"
		 + "&& !execution(* com.yumei.register.controller.*.*(..))")
	public void setToken() {
		// 生成token
		String token = CommonUtil.initToken();
		// 保存令牌到cookie
		saveTokenToCookie(token);
		// 保存令牌到redis
		saveTokenToRedis(token);
	}
	
	/**
	 * 保存随机生成的令牌到redis
	 * 
	 * @param token 随机令牌
	 */
	private void saveTokenToRedis(String token) {
		// 获取sessionId
		String sessionId = CommonUtil.getRequest().getSession().getId();
		// 拼接key
		String key = RedisConsts.TOKEN_KEY_PREV + sessionId;
		// 保存token到redis
		RedisUtil.set(key, token, CommonConsts.SESSION_TIME);
	}

	/**
	 * 保存随机生成的令牌到cookie
	 * 
	 * @param token 随机令牌
	 */
	private void saveTokenToCookie(String token) {
		// 获取response
		HttpServletResponse response = CommonUtil.getResponse();
		
		Cookie cookie  = new Cookie(CommonConsts.ACCESS_TOKEN_KEY, token);
		// 设置cookie保存时间
		cookie.setMaxAge(CommonConsts.SESSION_TIME);
		response.addCookie(cookie);
	}
}
