package com.yumei.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yumei.sys.entity.SysResource;

/**
 * 资源DAO接口。
 * 
 * @author Tei
 * @Date 2018年11月14日
 */
public interface SysResourceDao {
	/**
	 * 根据用户ID获取相关资源
	 * 
	 * @param userId 用户ID
	 * @return 用户可访问资源
	 */
	List<SysResource> getResourceByUserId(@Param("userId")Integer userId);
}
