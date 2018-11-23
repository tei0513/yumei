package com.yumei.common.utils;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.yumei.common.utils.consts.NumberConsts;

/**
 * 共通工具类。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
public final class CommonUtil {
	
	/**
	 * 隐藏构造函数
	 */
	private CommonUtil() {
		
	}
	
	/**
	 * 获取request
	 * 
	 * @return request
	 */
	public static HttpServletRequest getRequest() {
	   RequestAttributes ra = RequestContextHolder.getRequestAttributes();
	   ServletRequestAttributes sra = (ServletRequestAttributes) ra;
	   HttpServletRequest request = sra.getRequest();
	   return request;
	}
	
	
	/**
	 * 获取response
	 * 
	 * @return response
	 */
    public static HttpServletResponse getResponse() {
    	RequestAttributes ra = RequestContextHolder.getRequestAttributes();
    	ServletRequestAttributes sra = (ServletRequestAttributes) ra;
    	HttpServletResponse response = sra.getResponse();
    	return response;
    }
	
	/**
	 * 输出json格式对象
	 * 
	 * @param req request
	 * @param res response
	 * @param obj 输出对象
	 */
	public static void writeJson(HttpServletRequest req, HttpServletResponse res, Object obj) {
		// 设置响应头
		res.setHeader("content-type", "application/json;charset=UTF-8");
		ServletOutputStream outputStream = null;
		 try {
			 outputStream = res.getOutputStream();
			 
			 // Object -> json
			 String json = JSON.toJSONString(obj);
			 outputStream.write(json.getBytes());
			 outputStream.flush();
		 } catch (IOException e) {
			// TODO
		} 
	}
	
	
	/**
	 * 生成令牌<br>
	 * [备考]默认生成4位
	 * 
	 * @return 令牌
	 */
	public static String initToken() {
		return initToken(NumberConsts.NUM_4);
	}
	
	/**
	 * 生成令牌
	 * 
	 * @param num 保留位数
	 * @return 令牌
	 */
	public static String initToken(int num) {
		// 生成UUID
		String temp = UUID.randomUUID().toString().replaceAll("-", "");
		// 只保留前4位
		String uuid = temp.substring(0, num);
		return uuid;
	}

}
