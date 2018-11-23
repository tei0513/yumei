package com.yumei.common.aop;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.yumei.common.entity.BaseEntity;
import com.yumei.common.utils.CommonUtil;
import com.yumei.common.utils.StringChecker;
import com.yumei.common.utils.consts.NumberConsts;
import com.yumei.sys.entity.UserDetails;

/**
 * Dao类切面。
 * 
 * @author Tei
 * @Date 2018年11月15日
 */
@Component
@Aspect
@Order(NumberConsts.NUM_5)
public class MapperAop {
	
	/**
	 * 设置BaseEntity属性
	 * 
	 * @param point 切入点
	 */
	@Before("execution(* com.yumei.*.dao.*.save*(..)) || execution(* com.yumei.*.dao.*.update*(..))")
	public void setModifyInfo(JoinPoint point) {
		// 获取方法所有传参
		Object[] args = point.getArgs();
		// 获取session
		HttpSession session = CommonUtil.getRequest().getSession();
		// 获取登陆用户的信息
		UserDetails user = (UserDetails) session.getAttribute("user_details");
		String loginName = "";
		if (null == user) {
			loginName = "SYS";
		} else {
			loginName = user.getLoginName();
		}
		
		for (Object obj: args) {
			// 如果是BaseEntity类型的对象则设置相关属性
			if (obj instanceof BaseEntity) {
				obj = (BaseEntity) obj;
				
				// 第一次创建时添加创建人和创建时间
				if (StringChecker.isBlank(((BaseEntity) obj).getCreateUserName())) {
					
					// 设置创建时间
					((BaseEntity) obj).setCreateDate(new Date());
					// 设置创建人
					((BaseEntity) obj).setCreateUserName(loginName);
				}
				// 设置修改人
				((BaseEntity) obj).setUpdateUserName(loginName);
				// 设置修改时间
				((BaseEntity) obj).setUpdateDate(new Date());
			}
		}
	}
}
