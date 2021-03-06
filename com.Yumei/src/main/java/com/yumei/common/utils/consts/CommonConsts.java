package com.yumei.common.utils.consts;

/**
 * 通用常量池
 * 
 * @author Administrator
 * @Date 2018年11月11日
 */
public final class CommonConsts {
	/**
	 * 常量池隐藏构造函数
	 */
	private CommonConsts() {
	}
	
	/**
	 * 空字符串<br>
	 * 值是{@value}
	 */
	public static final String BLANK = "";
	/**
	 * 制表符<br>
	 * 值是{@value}
	 */
	public static final String TAB = "\t";
	/**
	 * 默认日期转换格式<br>
	 * 值是{@value}
	 */
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	
	/**
	 * application域scope<br>
	 * 值是{@value}
	 */
	public static final String APP_SCOPE = "application";
	
	/**
	 * 系统默认记录人<br>
	 * 值是{@value}
	 */
	public static final String SYS = "SYS";
	
	/**
	 * 激活状态<br>
	 * 值是{@value}
	 */
	public static final int ACTIVE = 1;
	
	/**
	 * 单例bean<br>
	 * 值是{@value}
	 */
	public static final String SINGLE_SCOPE = "single";
	
	/**
	 * 权限不足CODE<br>
	 * 值是{@value}
	 */
	public static final int PERMISSION_ERROR = 403;
	
	/** 
	 * cookie中存放token的key 
	 * 值是{@value}
	 */
	public static final String ACCESS_TOKEN_KEY = "Access_Token";
	
	/**
	 * Session生命周期<br>
	 * 值是{@value}
	 */
	public static final int SESSION_TIME = 60 * 60;
	
	/**
	 * 逗号<br>
	 * 值是{@value}
	 */
	public static final String COMA = ",";
	
	/**
	 * 冒号<br>
	 * 值是{@value}
	 */
	public static final String COLO = ":";
	
	/**
	 * null字段<br>
	 * 值是{@value}
	 */
	public static final String NULL = "null";
	/**
	 * OBECT左标记<br>
	 * 值是{@value}
	 */
	public static final String OBJECT_LEFT = "[";
	
	/**
	 * OBECT右标记<br>
	 * 值是{@value}
	 */
	public static final String OBJECT_RIGHT = "]";
	
	/**
	 * List集合左标记<br>
	 * 值是{@value}
	 */
	public static final String LIST_LEFT = "<";
	
	/**
	 * List集合右标记<br>
	 * 值是{@value}
	 */
	public static final String LIST_RIGHT = ">";
	
	/**
	 * Map集合左标记<br>
	 * 值是{@value}
	 */
	public static final String MAP_LEFT = "{";
	
	/**
	 * Map集合右标记<br>
	 * 值是{@value}
	 */
	public static final String MAP_RIGHT = "}";
}
