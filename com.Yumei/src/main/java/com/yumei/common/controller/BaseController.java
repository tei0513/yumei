package com.yumei.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yumei.common.result.builder.BaseResultBuilder;

/**
 * controller通用类。
 * 
 * @author Tei
 * @Date 2018年11月24日
 */
@Component
public class BaseController {
	/** 返回结果构造类 */
	@Autowired
	protected BaseResultBuilder resultBuilder;		
}
