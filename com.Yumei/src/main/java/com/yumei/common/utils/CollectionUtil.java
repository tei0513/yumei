package com.yumei.common.utils;

import java.util.Collection;

/**
 * 集合工具类。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
public final class CollectionUtil {
	
	/**
	 * 隐藏构造函数
	 */
	private CollectionUtil() {
		
	}
	
	/**
	 * 判断集合是否为空
	 * 
	 * @param collection 集合类型对象
	 * @return true:空集合,false:不为空
	 */
	public static boolean checkIsEmpty(Collection<?> collection) {
		if (null == collection || collection.isEmpty()) {
			return true;
		}
		return false;
	}
}
