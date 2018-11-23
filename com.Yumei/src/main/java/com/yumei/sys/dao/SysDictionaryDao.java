package com.yumei.sys.dao;


import java.util.List;

import com.yumei.sys.entity.SysDictionary;

/**
 * 登陆用户DAO接口。
 * 
 * @author Tei
 * @Date 2018年11月13日
 */
public interface SysDictionaryDao {
	/**
	 * 获取所有字典集合
	 * 
	 * @return 查询结果
	 */
	List<SysDictionary> findAll();
	
	/**
	 * 获取所有有效字典集合
	 * 
	 * @return 查询结果
	 */
	List<SysDictionary> findAvailability();
	
	/**
	 * 保存数据字典
	 * 
	 * @param dictionary 数据字典用Entity
	 * @return 操作成功数
	 */
	int saveDictionary(SysDictionary dictionary);
}
