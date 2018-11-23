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
import com.yumei.common.utils.consts.MessageConsts;

/**
 * 登陆过滤器。<br>
 * 【备考】判断用户有无登陆
 * 
 * @author Tei
 * @Date 2018年11月19日
 */
@Component
public class LoginFilter extends CommonFilterUtil implements Filter {

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
		
		// session中获取记录
		Object obj = req.getSession().getAttribute("user_details");
		
		// 未登录则返回错误信息
		if (null == obj) {
			BaseResult base = new BaseResult();
			base.setResultCode(MessageConsts.ME001L);
			base.setMsg(MessageUtil.getMessageByCode(MessageConsts.ME001L));
			CommonUtil.writeJson(req, res, base);
			return;
		}
		
		chain.doFilter(request, response);
	}

}
