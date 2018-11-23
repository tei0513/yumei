package com.yumei.sys.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.yumei.common.utils.CollectionUtil;
import com.yumei.common.utils.MessageUtil;
import com.yumei.common.utils.consts.CommonConsts;
import com.yumei.common.utils.consts.MessageConsts;
import com.yumei.sys.entity.SysResource;
import com.yumei.sys.entity.UserDetails;

/**
 * 
 * 
 * @author Tei
 * @Date 2018年11月21日
 */
@Component
public class AccessFilter extends CommonFilterUtil implements Filter {

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
		// 获取用户信息
		UserDetails user = (UserDetails) req.getSession().getAttribute("user_details");
		
		// 判断有没有权限
		List<SysResource> resources = user.getResources();
		
		boolean canAcess = false;
		
		if (!CollectionUtil.checkIsEmpty(resources)) {
			
			// 验证是否有权限
			for (SysResource resource:resources) {
				
				if (null == resource.getUrl()) {
					// TODO url为null会报错此处需要处理
					continue;
				}
				
				if (resource.getUrl().equals(requestURI)) {
					canAcess = true;
					break;
				}
			}
		}
		
		if (canAcess) {
			chain.doFilter(request, response);
			return;
		} else {
			// 获取权限不足Msg
			String errorMsg = MessageUtil.getMessageByCode(MessageConsts.SE0403);
			// 设置错误码
			res.sendError(CommonConsts.PERMISSION_ERROR, errorMsg);
			return;
		}
	}
}
