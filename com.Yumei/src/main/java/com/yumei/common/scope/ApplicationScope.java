package com.yumei.common.scope;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.yumei.common.utils.CollectionUtil;
import com.yumei.common.utils.consts.CommonConsts;
import com.yumei.sys.dao.SysMessageDao;
import com.yumei.sys.entity.SysMessage;

/**
 * application域操作类。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
@Component
@Scope(CommonConsts.APP_SCOPE)
public class ApplicationScope {
	
	@Autowired
	private SysMessageDao messageDao;
	
	/**
	 * 状态码信息池
	 */
	private HashMap<String, String> resultMsg;

	
	/**
	 * 获取状态码信息池
	 *
	 * @return result信息池
	 */
	public HashMap<String, String> getResultMsg() {
		return resultMsg;
	}


	/**
	 * 设置状态码信息池
	 *
	 * @param resultMsg result信息池
	 */
	public void setResultMsg(HashMap<String, String> resultMsg) {
		this.resultMsg = resultMsg;
	}


	/**
	 * 初始化application
	 */
	@PostConstruct
	public void init() {
		// 获取所有状态码信息
		List<SysMessage> messages = messageDao.findAll();
		
		if (!CollectionUtil.checkIsEmpty(messages)) {
			// 构建用于保存状态码的Map
			HashMap<String, String> resultInfo = new HashMap<String, String>();
			for (SysMessage message : messages) {
				// 保存状态码信息
				resultInfo.put(message.getResultCode(), message.getMessage());
				// 设置状态码信息池
				this.setResultMsg(resultInfo);
			}
		}
	}
}
