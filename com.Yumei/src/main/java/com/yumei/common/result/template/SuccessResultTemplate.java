package com.yumei.common.result.template;

import com.yumei.common.result.BaseResult;
import com.yumei.common.utils.MessageUtil;
import com.yumei.common.utils.consts.MessageConsts;
import com.yumei.common.validation.Validation;

/**
 * 成功信息返回魔板。
 * 
 * @author Tei
 * @Date 2018年11月24日
 */
public class SuccessResultTemplate extends BaseResult {
	/**
	 * 构造函数
	 */
	public SuccessResultTemplate() {
		// 设置成功CODE
		this.setResultCode(MessageConsts.MS0000);
		// 设置成功状态信息
		this.setMsg(MessageUtil.getMessageByCode(MessageConsts.MS0000));
		Validation validation = new Validation();
		// 设置验证是否通过
		validation.setValidate(true);
		// 设置验证信息
		this.setValidation(validation);
	}
}
