package com.yumei.common.result.builder;

import org.springframework.stereotype.Component;

import com.yumei.common.result.BaseResult;
import com.yumei.common.result.template.SuccessResultTemplate;
import com.yumei.common.result.template.ValidationFailResultTemplate;

/**
 * BaseResult构建类。
 * 
 * @author Tei
 * @Date 2018年11月24日
 */
@Component
public class BaseResultBuilder {
	/**
	 * 构建返回信息。
	 * 
	 * @return BaseResult
	 */
	public BaseResult build() {
		return new BaseResult();
	}
	
	/**
	 * 构建成功返回信息。
	 * 
	 * @return BaseResult
	 */
	public BaseResult buildSuccessResult() {
		return new SuccessResultTemplate();
	}
	
	/**
	 * 构建验证失败返回信息
	 * 
	 * @return BaseResult
	 */
	public BaseResult buildValidationFailResult() {
		return new ValidationFailResultTemplate();
	}
}
