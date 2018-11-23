package com.yumei.common.scope;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.yumei.common.utils.CollectionUtil;
import com.yumei.common.utils.consts.CommonConsts;
import com.yumei.sys.dao.SysDictionaryDao;
import com.yumei.sys.dao.SysMessageDao;
import com.yumei.sys.entity.SysDictionary;
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
	@Autowired
	private SysDictionaryDao dictionaryDao;
	
	/**
	 * 初始化application
	 */
	@PostConstruct
	public void init() {
		// 初始化状态码信息
		initMessage();
		// 初始化数据字典
		initDictionary();

	}

	/**
	 * 状态码信息池
	 */
	private HashMap<String, String> resultMsg;
	/**
	 * 数据字典集合
	 */
	private HashMap<String, String> dictionary;
	
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
	 * 获取 数据字典集合
	 *
	 * @return 数据字典集合
	 */
	public HashMap<String, String> getDictionary() {
		return dictionary;
	}


	/**
	 * 设置 数据字典集合
	 *
	 * @param dictionary 数据字典集合
	 */
	public void setDictionary(HashMap<String, String> dictionary) {
		this.dictionary = dictionary;
	}


	/**
	 * 初始化Message
	 */
	private void initMessage() {
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
	
	/**
	 * 初始化数据字典
	 */
	private void initDictionary() {
		List<SysDictionary> dictionaryList = dictionaryDao.findAvailability();
		
		if (!CollectionUtil.checkIsEmpty(dictionaryList)) {
			// 构建用户保存数据字典的Map
			HashMap<String, String> dictionaryInfo = new HashMap<String, String>();
			
			for (SysDictionary sdictionary : dictionaryList) {
				// 保存数据字典
				dictionaryInfo.put(sdictionary.getCode(), sdictionary.getValue());
				// 设置数据字典集合
				this.setDictionary(dictionaryInfo);
			}
		}
	}
}
