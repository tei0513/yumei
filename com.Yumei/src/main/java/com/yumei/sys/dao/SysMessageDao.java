package com.yumei.sys.dao;

import java.util.List;

import com.yumei.sys.entity.SysMessage;

/**
 * 状态码DAO接口。
 * 
 * @author Tei
 * @Date 2018年11月14日
 */
public interface SysMessageDao {
	/**
	 * 获取所有状态码信息
	 * 
	 * @return 所有状态码信息
	 */
	List<SysMessage> findAll();
}
