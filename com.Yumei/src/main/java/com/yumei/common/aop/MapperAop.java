package com.yumei.common.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.yumei.common.entity.BaseEntity;
import com.yumei.common.utils.StringChecker;

/**
 * Dao类切面。
 * 
 * @author Tei
 * @Date 2018年11月15日
 */
@Component
@Aspect
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
	
		for (Object obj: args) {
			// 如果是BaseEntity类型的对象则设置相关属性
			if (obj instanceof BaseEntity) {
				obj = (BaseEntity) obj;
				
				// 第一次创建时添加创建人和创建时间
				if (StringChecker.isBlank(((BaseEntity) obj).getCreateUserName())) {
					//TODO 设置创建人
					
					// 设置创建时间
					((BaseEntity) obj).setCreateDate(new Date());
				}
				//TODO 设置修改人
				
				// 设置修改时间
				((BaseEntity) obj).setUpdateDate(new Date());
			}
		}
	}
}
