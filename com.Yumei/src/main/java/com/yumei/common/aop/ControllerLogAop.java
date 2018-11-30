package com.yumei.common.aop;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.yumei.common.model.BaseModel;
import com.yumei.common.utils.CollectionUtil;
import com.yumei.common.utils.CommonUtil;
import com.yumei.common.utils.DateUtil;
import com.yumei.common.utils.LogUtil;
import com.yumei.common.utils.StringUtil;
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
	 * get方法前缀<br>
	 */
	public static final String GET_METHOD_PREIX = "get";

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
		// 获取requestBody数据
		String requestBodyParameter = getRequestBodyParameter(point);
		// 创建输出语句
		String loginInfo = createInfo(className, methodName, ipAddress, method, parameter,
				requestBodyParameter);
		LogUtil.controllerLog(loginInfo);
	}

	/**
	 * 获取@requestbody的参数
	 * 
	 * @param point 切入点
	 * @return requestbody的参数
	 */
	private String getRequestBodyParameter(JoinPoint point) {
		Object[] args = point.getArgs();
		String parameter = "";
		if (null != args && args.length > 0) {
			for (Object obj : args) {
				if (obj instanceof BaseModel) {
					// 解析obj
					StringBuffer result = new StringBuffer("");
					parameter = parseObj(obj, result);
				}
			}
		}
		return parameter;
	}

	/**
	 * 解析object
	 * 
	 * @param obj obj
	 * @param result 结果集
	 * @return 解析结果
	 */
	private String parseObj(Object obj, StringBuffer result) {
		return parseObj(obj, false, false, result);
	}
	
	/**
	 * 解析object对向
	 * 
	 * @param obj obj
	 * @param isList 是否是list集合
	 * @param isMap 是否是map集合
	 * @param result 结果集
	 * @return 解析结果
	 */
	private String parseObj(Object obj, boolean isList, boolean isMap, StringBuffer result) {
		// 获取所有字段
		Field[] fields = obj.getClass().getDeclaredFields();

		if (null == fields || fields.length <= 0) {
			return CommonConsts.BLANK;
		}
		// 初始化字值
		Object fieldValue = null;
		for (Field field : fields) {
			// 字段名称
			String fieldName = field.getName();
			// 过滤serialVersionUID
			if ("serialVersionUID".equals(fieldName)) {
				continue;
			}
			// 获取字段值
			fieldValue = getFieldValue(obj, fieldName);
			
			if ((fieldValue instanceof String) || (fieldValue instanceof Number)  
					|| (fieldValue instanceof Boolean)) {
				// 解析基础类型
				parseBaseType(fieldName, fieldValue, result);
			} else if (fieldValue instanceof Date) {
				// 解析Date类型
				parseDate(fieldName, fieldValue, result);
			} else if (fieldValue instanceof Collection) {
				// 解析list类型
				parseList(fieldName, fieldValue, result);
			} else if (fieldValue instanceof Map) {
				// 解析Map类型
				parseMap(fieldName, fieldValue, result);
			}
		}
		// 最后处理
		return afterProcess(result, isList, isMap);
		
	}
	
	/**
	 * 解析最后处理
	 * 
	 * @param result 解析结果
	 * @param isList 是否是list集合
	 * @param isMap 是否是map集合
	 * @return 解析结果
	 */
	private String afterProcess(StringBuffer result, boolean isList, boolean isMap) {
		String left = "";
		String right = "";
		if (isList) {
			// list集合的处理
			left = CommonConsts.LIST_LEFT;
			right = CommonConsts.LIST_RIGHT;
		} else if (isMap) {
			// map集合的处理
			left = CommonConsts.COLO + CommonConsts.MAP_LEFT;
			right = CommonConsts.MAP_RIGHT;
		} else {
			// object的处理
			left = CommonConsts.OBJECT_LEFT;
			right = CommonConsts.OBJECT_RIGHT;
		}
		result.insert(0, left);
		result.append(right);
		
		return result.toString();
	}

	/**
	 * 反射获取字段内容
	 * 
	 * @param obj 反射类
	 * @param fieldName 反射字段名
	 * @return 反射字段值
	 */
	private Object getFieldValue(Object obj, String fieldName) {
		// 获取get方法名称
		String methodName = GET_METHOD_PREIX + StringUtil.topUpper(fieldName);
		
		Method method;
		try {
			// 获取get方法
			method = obj.getClass().getMethod(methodName);
			// 调用get方法获取值
			obj = method.invoke(obj);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
		

	/**
	 * 解析Map类型
	 * 
	 * @param fieldName 字段名称
	 * @param fieldValue 字段值
	 * @param result 保存结果
	 */
	private void parseMap(String fieldName, Object fieldValue, StringBuffer result) {
		Map<?, ?> map = (Map<?, ?>) fieldValue;
		// 过滤空map
		if (null == map || map.size() == 0) {
			return;
		}
		
		StringBuffer outResult = new StringBuffer(CommonConsts.OBJECT_LEFT);
		/*
		 * 此处默认map的key为基础类型。
		 */
		map.forEach((k, v) -> {
			StringBuffer mapResult = new StringBuffer(CommonConsts.MAP_LEFT);
			// 解析value
			StringBuffer valueResult = new StringBuffer();
			
			if ((v instanceof String) || (v instanceof Number)  
					|| (v instanceof Boolean)) {
				// 解析基础类型
				parseBaseType(CommonConsts.BLANK, v, valueResult);
			} else if (v instanceof Date) {
				// 解析Date类型
				parseDate(CommonConsts.BLANK, v, valueResult);
			} else if (v instanceof Collection) {
				// 解析list类型
				parseList(CommonConsts.BLANK, v, valueResult);
			} else if (v instanceof Map) {
				// 解析Map类型
				parseMap(CommonConsts.BLANK, v, valueResult);
			} else {
				// Object类型
				parseObj(v, false, true, valueResult);
			}
			
			// 组合key和value的输出
			mapResult.append(k + CommonConsts.BLANK + valueResult);
			mapResult.append(CommonConsts.MAP_RIGHT);
			outResult.append(mapResult + CommonConsts.COMA);
		});
		
		outResult.deleteCharAt(outResult.length() - 1);
		outResult.append(CommonConsts.OBJECT_RIGHT);
		
		addResult(fieldName, outResult.toString(), result);
	}

	/**
	 * 解析Date类型
	 * 
	 * @param fieldName 字段名
	 * @param fieldValue 字段值
	 * @param result 保存结果
	 */
	private void parseDate(String fieldName, Object fieldValue, StringBuffer result) {
		// 日期格式转化成String
		String date = DateUtil.convertToString((Date) fieldValue);
		addResult(fieldName, date, result);
	}
	
	/**
	 * 保存结果
	 * 
	 * @param fieldName 字段名称
	 * @param fieldValue 字段值
	 * @param result 保存结果
	 */
	private void addResult(String fieldName, Object fieldValue, StringBuffer result) {
		if (result.length() > 0) {
			result.append(CommonConsts.COMA);
		}
		result.append(fieldName + CommonConsts.COLO + fieldValue);
	}

	/**
	 * 解析List类型
	 * 
	 * @param fieldName 字段名
	 * @param fieldValue 字段值
	 * @param result 保存结果
	 */
	private void parseList(String fieldName, Object fieldValue, StringBuffer result) {
		List<?> list = (List<?>) fieldValue;
		
		// 空集合直接返回
		if (CollectionUtil.checkIsEmpty(list)) {
			addResult(fieldName, CommonConsts.NULL, result);
			return;
		}
		
		StringBuffer listResult = new StringBuffer(CommonConsts.LIST_LEFT);
		
		// 循环迭代解析对象
		for (int i = 0; i < list.size(); i++) {
			StringBuffer tempResult = new StringBuffer("");
			Object obj = list.get(i);
			// 解析类对象
			parseObj(obj, true, false, tempResult);
			
			listResult.append(tempResult + CommonConsts.COMA);
		}
		
		// 去除最后一个逗号
		listResult.deleteCharAt(listResult.length() - 1);
		// 补全括号
		listResult.append(CommonConsts.LIST_RIGHT);
		
		addResult(fieldName, listResult.toString(), result);
	}


	/**
	 * 解析基础类型
	 * 
	 * @param fieldName 字段名称
	 * @param fieldValue 字段值
	 * @param result 保存结果
	 */
	private void parseBaseType(String fieldName, Object fieldValue, StringBuffer result) {
		// 保存结果
		addResult(fieldName, fieldValue, result);
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
	 * @param requestBodyParameter requestBody参数
	 * @return log输出语句
	 */
	private String createInfo(String className, String methodName, String ipAddress, 
			String method, String parameter, String requestBodyParameter) {
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
		info.append(CommonConsts.TAB);
		info.append(requestBodyParameter);
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
