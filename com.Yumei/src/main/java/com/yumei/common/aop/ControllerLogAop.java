package com.yumei.common.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.yumei.common.utils.CommonUtil;
import com.yumei.common.utils.LogUtil;
import com.yumei.common.utils.consts.CommonConsts;
import com.yumei.common.utils.consts.NumberConsts;

/**
 * Controller层日志输出Log。
 * 
 * @author Tei
 * @Date 2018年11月24日
 */
@Component
@Aspect
@Order(NumberConsts.NUM_20)
public class ControllerLogAop {
	/**
	 * controller日志开始标志<br>
	 */
	public static final String START_CONTROLLER = "----------------------Controller Start----------------------";
	/**
	 * controller日志结束标志<br>
	 */
	public static final String END_CONTROLLER = "----------------------Controller End------------------------";

	/**
	 * 进入切点记录日志
	 * 
	 * @param point 切入点
	 */
	@Before("execution(* com.yumei.*.controller.*.*(..))")
	public void doBefore(JoinPoint point) {
		// 输出controller日志记录开始标志
		LogUtil.controllerLog(START_CONTROLLER);
		// 获取类名称
		String className = point.getTarget().getClass().getName();
		// 方法名称
		String methodName = point.getSignature().getName();
		// 获取IP地址
		String ipAddress = getIpAddress();
		// 获取请求类型
		String method = getRequestMethod();
		// 获取请求参数
		String parameter = getRequestParameter();
		// 创建输出语句
		String loginInfo = createInfo(className, methodName, ipAddress, method, parameter);
		
		LogUtil.controllerLog(loginInfo);
	}
	
	/**
	 * controller调用结束后记录日志
	 */
	@After("execution(* com.yumei.*.controller.*.*(..))")
	public void doAfter() {
		LogUtil.controllerLog(END_CONTROLLER);
	}


	/**
	 * 构建log输出语句
	 * 
	 * @param className  类名
	 * @param methodName 方法名
	 * @param ipAddress  IP
	 * @param method     请求方式
	 * @param parameter  请求参数
	 * @return log输出语句
	 */
	private String createInfo(String className, String methodName, String ipAddress, 
			String method, String parameter) {
		StringBuffer info = new StringBuffer();
		info.append(ipAddress);
		info.append(CommonConsts.TAB);
		info.append(className);
		info.append(CommonConsts.TAB);
		info.append(methodName);
		info.append(CommonConsts.TAB);
		info.append(method);
		info.append(CommonConsts.TAB);
		info.append(parameter);
		return info.toString();
	}

	/**
	 * 获取post请求的参数
	 * 
	 * @return 请求参数
	 */
	private String getRequestParameter() {
		HttpServletRequest request = CommonUtil.getRequest();
		Map<String, String[]> params = request.getParameterMap();
		StringBuffer queryString = new StringBuffer("[");
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				if (i > 0) {
					// 首个值前不加逗号
					queryString.append(",");
				}
				String value = values[i];
				queryString.append(key + ":" + value);
			}
		}
		queryString.append("]");
		return queryString.toString();
	}

	/**
	 * 获取请求类型
	 * 
	 * @return 请求类型
	 */
	private String getRequestMethod() {
		// 获取request
		HttpServletRequest request = CommonUtil.getRequest();
		return request.getMethod();
	}
	

	/**
	 * 获取IP地址
	 * 
	 * @return ip地址
	 */
	private String getIpAddress() {
		// 获取request
		HttpServletRequest request = CommonUtil.getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
