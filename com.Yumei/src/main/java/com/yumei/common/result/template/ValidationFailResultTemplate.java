package com.yumei.common.result.template;

import com.yumei.common.result.BaseResult;
import com.yumei.common.utils.MessageUtil;
import com.yumei.common.utils.consts.MessageConsts;

/**
 * 验证失败返回结果魔板。
 * 
 * @author Tei
 * @Date 2018年11月24日
 */
public class ValidationFailResultTemplate extends BaseResult {
	/**
	 * 构造函数
	 */
	public ValidationFailResultTemplate() {
		// 设置状态码
		this.setResultCode(MessageConsts.ME001V);
		// 设置状态码信息
		this.setMsg(MessageUtil.getMessageByCode(MessageConsts.ME001V));
	}
}
