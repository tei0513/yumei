package com.yumei.common.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 日志输出工具类。
 * 
 * @author Tei
 * @Date 2018年11月24日
 */
public final class LogUtil {
	/** controller层log输出 */
	private static final Logger CONTROLLER_LOG = LogManager.getLogger("controllerLogger");
	/** service层log输出 */
	private static final Logger SERVICE_LOG = LogManager.getLogger("serviceLogger");
	/** error层log输出 */
	private static final Logger ERROR_LOG = LogManager.getLogger("errorLogger");
	
	/**
	 * 输出controller层日志
	 * 
	 * @param msg 输出信息
	 */
	public static void controllerLog(String msg) {
		CONTROLLER_LOG.info(msg);
	}
	
	/**
	 * 输出service层日志
	 * 
	 * @param msg 输出信息
	 */
	public static void serviceLog(String msg) {
		SERVICE_LOG.info(msg);
	}
	
	/**
	 * 输出error信息
	 * 
	 * @param msg 输出信息
	 */
	public static void errorLog(String msg) {
		ERROR_LOG.error(msg);
	}
	
}
