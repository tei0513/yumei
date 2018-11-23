package com.yumei.sys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.yumei.common.result.BaseResult;
import com.yumei.common.utils.CommonUtil;
import com.yumei.common.utils.MessageUtil;
import com.yumei.common.utils.RedisUtil;
import com.yumei.common.utils.StringChecker;
import com.yumei.common.utils.consts.CommonConsts;
import com.yumei.common.utils.consts.MessageConsts;
import com.yumei.common.utils.consts.RedisConsts;

/**
 * 令牌验证过滤器。
 * 
 * @author Tei
 * @Date 2018年11月21日
 */
@Component
public class TokenFilter extends CommonFilterUtil implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ServletRequest -> HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// ServletResponse -> HttpServletResponse
		HttpServletResponse res = (HttpServletResponse) response;
		
		// 获取访问URL
		String requestURI = this.getRequestURI(req);
		
		// 可被放行的url
		if (!this.checkShouldFilter(requestURI)) {
			chain.doFilter(request, response);
			return;
		}
		
		/*
		 * 检查Token是否一致
		 * 不一致的场合:
		 * 		1.恶意的session伪装
		 * 		2.账号在别处登陆
		 */
		if (!checkToken(req.getHeader(CommonConsts.ACCESS_TOKEN_KEY))) {
			BaseResult base = new BaseResult();
			base.setResultCode(MessageConsts.SE0500);
			base.setMsg(MessageUtil.getMessageByCode(MessageConsts.SE0500));
			CommonUtil.writeJson(req, res, base);
			return;
		} 
		
		chain.doFilter(request, response);
	}
	
	/**
	 * 验证token
	 * 
	 * @param reqToken 请求头中的token 
	 * @return true:验证通过,false:验证失败
	 */
	private boolean checkToken(String reqToken) {
		// 获取sessionId
		String sessionId = CommonUtil.getRequest().getSession().getId();
		// 拼接key
		String key = RedisConsts.TOKEN_KEY_PREV + sessionId;
		// 获取token
		String token = (String) RedisUtil.get(key);
		
		if (StringChecker.isBlank(token)) {
			return false;
		}
		
		// 比较token是否相同
		if (!StringChecker.checkIsEquals(reqToken, token)) {
			return false;
		}
		
		return true;
	}
}
