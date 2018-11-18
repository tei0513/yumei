package com.yumei.register.service;

import com.yumei.common.result.BaseResult;
import com.yumei.register.dto.RegisterInDto;

/**
 * 注册用Service接口。
 * 
 * @author Tei
 * @Date 2018年11月18日
 */
public interface RegisterService {
	
	/**
	 * 用户注册
	 * 
	 * @param inDto 注册用InDto
	 * @return 操作结果
	 */
	BaseResult register(RegisterInDto inDto);
		
}
